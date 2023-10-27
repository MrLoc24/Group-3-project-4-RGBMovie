package com.rgbmovie.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.rgbmovie.dto.*;
import com.rgbmovie.helpers.AppConstant;
import com.rgbmovie.model.UserModel;
import com.rgbmovie.model.UserRoleModel;
import com.rgbmovie.model.WorkplaceModel;
import com.rgbmovie.service.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/users")
public class UserController {

    Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
            "cloud_name", AppConstant.cloudinaryName,
            "api_key", AppConstant.apiKey,
            "api_secret", AppConstant.apiSecret,
            "secure", AppConstant.secure));
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private TheaterService theaterService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private WorkplaceService workplaceService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping
    public String index(@RequestParam(value = "username", defaultValue = "", required = false) String username, @RequestParam(value = "workplace", defaultValue = "", required = false) String worlplace, Model model) {
        if (!username.isEmpty()) {
            model.addAttribute("user", userService.findByUsername(username));
            return "user/profile";
        }
        List<RoleDTO> roleList = roleService.getAll().stream().map(roleModel -> modelMapper.map(roleModel, RoleDTO.class)).toList();
        List<TheaterDTO> theaterList = theaterService.getAll().stream().map(theaterModel -> modelMapper.map(theaterModel, TheaterDTO.class)).toList();

        //For add user form
        model.addAttribute("userRole", new UserRoleDTO());
        model.addAttribute("user", new UserDTO());
        model.addAttribute("theaters", theaterList);
        model.addAttribute("roles", roleList);
        //For staff of theater
        if (Integer.parseInt(worlplace) != 0) {
            model.addAttribute("users", userService.getByTheater(Integer.parseInt(worlplace)));
            return "user/index";
        }
        //For user list
        //1 for staff
        model.addAttribute("users", userService.getUserByRole(1));
        return "user/index";
    }

    @PostMapping("/add")
    public String addNew(@ModelAttribute UserDTO userDTO, @ModelAttribute RoleDTO roleDTO, @ModelAttribute UserRoleDTO userRoleDTO, @RequestParam("workPlace") int pk, @RequestParam("image") MultipartFile multipartFile, Model model) throws IOException {
        WorkplaceDTO workplaceDTO = new WorkplaceDTO();
        Map uploadResult = cloudinary.uploader().upload(multipartFile.getBytes(), ObjectUtils.emptyMap());
        userDTO.setImages(uploadResult.get("url").toString());
        //Default password
        userDTO.setPassword(new BCryptPasswordEncoder().encode("123456"));
        userDTO.setEnabled(true);
        UserModel result = userService.addNew(modelMapper.map(userDTO, UserModel.class));
        userRoleDTO.setUserId(result.getPk());
        workplaceDTO.setUserId(result.getPk());
        workplaceDTO.setTheaterId(pk);
        workplaceService.addNewWorker(modelMapper.map(workplaceDTO, WorkplaceModel.class));
        userRoleService.addNewUserRole(modelMapper.map(userRoleDTO, UserRoleModel.class));
        return "redirect:/users";
    }

    @GetMapping("/status")
    public String changeStatus(@RequestParam("id") int id, Model model) {
        UserModel userModel = userService.findById(id);
        //change status based on user
        userModel.setEnabled(!userModel.getEnabled());
        if (userService.update(userModel)) model.addAttribute("message", "Failed to change status of user");
        else model.addAttribute("message", "Deleted");
        return "redirect:/users";
    }

    @PutMapping("/edit")
    public String edit(@ModelAttribute("user") UserModel user, Model model,
                       @RequestParam("image") MultipartFile multipartFile, @RequestParam(value = "oldImage", required = false) String oldImage) throws IOException {
        String fileName = "";
        fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        if (fileName.isEmpty()) {
            user.setImages(oldImage);
            boolean result = userService.updateWithoutPassword(user);
            if (result) {
                return "redirect:/users?username=" + user.getUsername();
            }
            return "redirect:/users";
        } else {
            Map uploadResult = cloudinary.uploader().upload(multipartFile.getBytes(), ObjectUtils.emptyMap());
            user.setImages(uploadResult.get("url").toString());
            boolean result = userService.updateWithoutPassword(user);
            if (result) {
                return "redirect:/users?username=" + user.getUsername();
            }
            return "redirect:/users";
        }

    }

    @PostMapping("/deactivate")
    public String setStatus(@RequestParam("pk") int pk) {
        boolean res = userService.updateEnable(pk, false);
        if (res) {
            return "redirect:/auth/logout";
        } else return "redirect:/users";
    }

    @PostMapping("/changePassword")
    public String setPassword(@RequestParam("currentPassword") String currentPassword, @RequestParam("newPassword") String newPassword, @RequestParam("pk") int pk, Model model) {
        UserModel result = userService.findById(pk);
        if (result != null) {
            if (passwordEncoder.matches(currentPassword, result.getPassword())) {
                userService.updatePassword(passwordEncoder.encode(newPassword), pk);
                return "redirect:/auth/logout";
            }
        }
        return "redirect:/users";
    }
}


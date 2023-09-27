package com.rgbmovie.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.rgbmovie.dto.RoleDTO;
import com.rgbmovie.dto.TheaterDTO;
import com.rgbmovie.dto.UserDTO;
import com.rgbmovie.dto.UserRoleDTO;
import com.rgbmovie.helpers.AppConstant;
import com.rgbmovie.model.UserModel;
import com.rgbmovie.model.UserRoleModel;
import com.rgbmovie.service.RoleService;
import com.rgbmovie.service.TheaterService;
import com.rgbmovie.service.UserRoleService;
import com.rgbmovie.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    private ModelMapper modelMapper;

    @GetMapping
    public String index(@RequestParam(value = "username", defaultValue = "", required = false) String username, Model model) {
        if (!username.isEmpty()) {
            model.addAttribute("user", userService.findByUsername(username));
            return "user/profile";
        }
        List<RoleDTO> roleList = roleService.getAll().stream().map(roleModel -> modelMapper.map(roleModel, RoleDTO.class)).toList();
        List<TheaterDTO> theaterList = theaterService.getAll().stream().map(theaterModel -> modelMapper.map(theaterModel, TheaterDTO.class)).toList();
        //For user list
        //1 for staff
        model.addAttribute("users", userService.getUserByRole(1));
        //For add user form
        model.addAttribute("userRole", new UserRoleDTO());
        model.addAttribute("user", new UserDTO());
        model.addAttribute("theaters", theaterList);
        model.addAttribute("roles", roleList);
        return "user/index";
    }

    @PostMapping("/add")
    public String addNew(@ModelAttribute UserDTO userDTO, @ModelAttribute RoleDTO roleDTO, @ModelAttribute UserRoleDTO userRoleDTO, @RequestParam("image") MultipartFile multipartFile, Model model) throws IOException {
        Map uploadResult = cloudinary.uploader().upload(multipartFile.getBytes(), ObjectUtils.emptyMap());
        userDTO.setImages(uploadResult.get("url").toString());
        //Default password
        userDTO.setPassword(new BCryptPasswordEncoder().encode("123456"));
        userDTO.setEnabled(true);
        userRoleDTO.setUserId(userService.addNew(modelMapper.map(userDTO, UserModel.class)).getPk());
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
}


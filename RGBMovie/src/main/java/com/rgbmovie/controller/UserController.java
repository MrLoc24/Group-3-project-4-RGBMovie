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
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/users")
public class UserController {
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
    Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
            "cloud_name", AppConstant.cloudinaryName,
            "api_key", AppConstant.apiKey,
            "api_secret", AppConstant.apiSecret,
            "secure", AppConstant.secure));

    @GetMapping
    public String index(Model model){
        List<RoleDTO> roleList = roleService.getAll().stream().map(roleModel -> modelMapper.map(roleModel, RoleDTO.class)).toList();
        List<TheaterDTO> theaterList = theaterService.getAll().stream().map(theaterModel -> modelMapper.map(theaterModel, TheaterDTO.class)).toList();
        //For user list
        model.addAttribute("users", userService.getAll());
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
        userDTO.setPassword(new BCryptPasswordEncoder().encode("123456"));
        userDTO.setEnabled(true);
        userRoleDTO.setUserId(userService.addNew(modelMapper.map(userDTO, UserModel.class)).getPk());
        System.out.println(userRoleDTO.getUserId());
        System.out.println(userRoleDTO.getRoleId());
        userRoleService.addNewUserRole(modelMapper.map(userRoleDTO, UserRoleModel.class));
        return "redirect:/users";
    }

}

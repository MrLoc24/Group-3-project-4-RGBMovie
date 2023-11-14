package com.rgbmovie.api;

import com.rgbmovie.dto.UserDTO;
import com.rgbmovie.model.UserModel;
import com.rgbmovie.service.UserService;
import jakarta.annotation.security.RolesAllowed;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class ApiUserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/edit")
    public Object editWithoutPassword(@RequestBody UserDTO userDTO) {
        return userService.updateWithoutPassword(modelMapper.map(userDTO, UserModel.class)) ? new ResponseEntity<String>("Change Success", HttpStatus.OK) : new ResponseEntity<String>("Something wrong", HttpStatus.BAD_REQUEST);
    }

    private boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @GetMapping("/profile/{username}")
    public Object getProfile(@PathVariable("username") String username) {
        UserDTO userDTO = new UserDTO();
        if (isInteger("usernanme")) {
            userDTO = modelMapper.map(userService.findById(Integer.parseInt(username)), UserDTO.class);
        } else {
            userDTO = modelMapper.map(userService.findByUsername(username), UserDTO.class);
        }
        return userDTO != null ? new ResponseEntity<>(userDTO, HttpStatus.OK) : new ResponseEntity<>("Something Wrong", HttpStatus.NO_CONTENT);
    }

    @PostMapping("/edit/password/{username}")
    public Object editPassword(@RequestBody PasswordChangeRequest passwordChangeRequest, @PathVariable("username") String username) {
        UserDTO userDTO = modelMapper.map(userService.findByUsername(username), UserDTO.class);
        if (passwordChangeRequest.password.equals(passwordChangeRequest.newPassword))
            return new ResponseEntity<>("Same password", HttpStatus.BAD_REQUEST);
        if (userDTO != null) {
            if (passwordEncoder.matches(passwordChangeRequest.password, userDTO.getPassword())) {
                userService.updatePassword(passwordEncoder.encode(passwordChangeRequest.newPassword), userDTO.getPk());
            }
        }
        return new ResponseEntity<>("Password changed", HttpStatus.OK);
    }

    @Data
    @Getter
    @Setter
    private static class PasswordChangeRequest {
        private String password;
        private String newPassword;

        // getters and setters
    }
}

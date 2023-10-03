package com.rgbmovie.api;

import com.rgbmovie.dto.UserDTO;
import com.rgbmovie.model.UserModel;
import com.rgbmovie.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class ApiUserController {
    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/edit")
    public Object editWithoutProfile(@RequestBody UserDTO userDTO) {
        return userService.updateWithoutPassword(modelMapper.map(userDTO, UserModel.class)) ? new ResponseEntity<String>("Change Success", HttpStatus.OK) : new ResponseEntity<String>("Something wrong", HttpStatus.BAD_REQUEST);
    }
}

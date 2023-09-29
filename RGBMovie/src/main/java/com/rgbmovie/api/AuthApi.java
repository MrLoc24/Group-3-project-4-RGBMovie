package com.rgbmovie.api;


import com.rgbmovie.dto.UserDTO;
import com.rgbmovie.model.UserRoleModel;
import com.rgbmovie.service.UserRoleService;
import com.rgbmovie.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.rgbmovie.model.AuthResponse;
import com.rgbmovie.model.LoginModel;
import com.rgbmovie.model.UserModel;
import com.rgbmovie.security.JwtTokenUtil;

@RestController
@RequestMapping("/api")
public class AuthApi {
    @Autowired
    AuthenticationManager authManager;
    @Autowired
    JwtTokenUtil jwtUtil;
    @Autowired
    private UserService userService;
    @Autowired
    private UserRoleService userRoleService;

    //Api for login
    @PostMapping("/auth")
    public ResponseEntity<?> login(@RequestBody LoginModel loginModel) {
        try {
            Authentication authentication = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginModel.getUsername(), loginModel.getPassword())
            );
            UserDetails user = (UserDetails) authentication.getPrincipal();
            String accessToken = jwtUtil.generateToken(loginModel);
            AuthResponse response = new AuthResponse(user.getUsername(), accessToken);
            return ResponseEntity.ok().body(response);

        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    //For adding new user from React
    @PostMapping("/signup")
    public Object signUp(@RequestBody UserDTO userDTO) {
        try {
            userDTO.setPassword(new BCryptPasswordEncoder().encode(userDTO.getPassword()));
            userDTO.setEnabled(true);
            UserRoleModel userRoleModel = new UserRoleModel();
            userRoleModel.setRoleId(2);
            UserModel userModel = userService.addNew(new ModelMapper().map(userDTO, UserModel.class));
            if (userModel == null) {
                return new ResponseEntity<String>("Add failed", HttpStatus.BAD_REQUEST);
            } else {
                userRoleModel.setUserId(userModel.getPk());
                userRoleService.addNewUserRole(userRoleModel);
                return new ResponseEntity<String>("Ok", HttpStatus.OK);
            }
        } catch (Exception e) {
                return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }


    }
}

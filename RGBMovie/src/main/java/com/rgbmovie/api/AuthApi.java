package com.rgbmovie.api;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.rgbmovie.model.AuthResponse;
import com.rgbmovie.model.LoginModel;
import com.rgbmovie.model.UserModel;
import com.rgbmovie.security.JwtTokenUtil;

@RestController
public class AuthApi {
	@Autowired AuthenticationManager authManager;
    @Autowired JwtTokenUtil jwtUtil;
     
    @PostMapping("/api/auth")
    public ResponseEntity<?> login(@RequestBody LoginModel loginModel ) {
        try {
        	System.out.println(loginModel.getPassword());
            System.out.println(loginModel.getUsername());
            Authentication authentication = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginModel.getUsername(), loginModel.getPassword())
            );            
            UserDetails user = (UserDetails) authentication.getPrincipal();
            System.out.println(user.getUsername());
            String accessToken = jwtUtil.generateToken(loginModel);
            AuthResponse response = new AuthResponse(user.getUsername(), accessToken);
             
            return ResponseEntity.ok().body(response);
             
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}

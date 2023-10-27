package com.rgbmovie.config;

import com.rgbmovie.model.UserModel;
import com.rgbmovie.repository.UserRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.io.Serial;


@Service
public class CustomUserDetailServiceImpl implements UserDetailsService {
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);
        UserModel userModel = userRepository.findByUsernameOrEmail(username, username);
        if (userModel == null) {
            throw new UsernameNotFoundException("Ten dang nhap khong ton tai");
        }
        return new CustomUserDetailService(userModel);
    }
}

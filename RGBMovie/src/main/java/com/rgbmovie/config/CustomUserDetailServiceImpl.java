package com.rgbmovie.config;

import com.rgbmovie.model.UserModel;
import com.rgbmovie.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel userModel = userRepository.findUserModelByUsernameOrEmail(username);
        if(userModel == null){
            throw new UsernameNotFoundException("Ten dang nhap khong ton tai");
        }
        return new CustomUserDetails(userModel);
    }
}

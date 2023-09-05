package com.rgbmovie.service.impl;

import com.rgbmovie.model.UserModel;
import com.rgbmovie.repository.UserRepository;
import com.rgbmovie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;


    @Override
    public List<UserModel> getAll() {
        return userRepository.findAll();
    }
    
    @Override
    public UserModel findByUsername(String name) {
    	// TODO Auto-generated method stub
    	return userRepository.findUserModelByUsernameOrEmail(name);
    }
}

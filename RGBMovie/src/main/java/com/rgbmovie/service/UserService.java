package com.rgbmovie.service;

import com.rgbmovie.model.UserModel;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {
    List<UserModel> getAll();
    UserModel findByUsername(String name);
}

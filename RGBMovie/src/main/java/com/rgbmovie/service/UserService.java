package com.rgbmovie.service;

import com.rgbmovie.dto.UserDTO;
import com.rgbmovie.model.UserModel;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<UserModel> getAll();

    UserModel findByUsername(String name);

    public UserModel addNew(UserModel userModel);

    public UserModel findById(int id);

    public boolean update(UserModel userModel);

    public boolean updateWithoutPassword(UserModel user);

    public boolean updatePassword(String password, int pk);

    public boolean updateEnable(int pk, boolean enable);

    public List<UserModel> getUserByRole(int number);

    public List<UserModel> getByTheater(int id);
}

package com.rgbmovie.service;

import com.rgbmovie.model.UserRoleModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserRoleService {
    void addNewUserRole(UserRoleModel userRoleModel);
    List<UserRoleModel> getAll();
}

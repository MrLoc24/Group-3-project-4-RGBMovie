package com.rgbmovie.service.impl;

import com.rgbmovie.model.UserRoleModel;
import com.rgbmovie.repository.UserRoleRepository;
import com.rgbmovie.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Override
    public void addNewUserRole(UserRoleModel userRoleModel) {
        userRoleRepository.saveAndFlush(userRoleModel);
    }

    @Override
    public List<UserRoleModel> getAll() {
        return userRoleRepository.findAll();
    }
}

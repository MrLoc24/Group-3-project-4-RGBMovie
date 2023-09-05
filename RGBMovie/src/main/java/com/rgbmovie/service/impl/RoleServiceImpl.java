package com.rgbmovie.service.impl;

import com.rgbmovie.model.RoleModel;
import com.rgbmovie.repository.RoleRepository;
import com.rgbmovie.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;
    @Override
    public List<RoleModel> getAll() {
        return roleRepository.findAll();
    }
}

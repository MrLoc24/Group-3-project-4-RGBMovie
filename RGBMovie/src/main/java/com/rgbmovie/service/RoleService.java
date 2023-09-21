package com.rgbmovie.service;

import com.rgbmovie.model.RoleModel;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface RoleService {
    //Only use for authentication
    public List<RoleModel> getAll();

}

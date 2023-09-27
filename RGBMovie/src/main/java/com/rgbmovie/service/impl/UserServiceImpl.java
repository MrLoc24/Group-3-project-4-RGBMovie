package com.rgbmovie.service.impl;

import com.rgbmovie.dto.UserDTO;
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

    @Override
    public UserModel addNew(UserModel userModel) {
        return userRepository.saveAndFlush(userModel);
    }

    @Override
    public UserModel findById(int id) {
        return userRepository.getReferenceById(id);
    }

    @Override
    public boolean update(UserModel userModel) {
        try {
            userRepository.saveAndFlush(userModel);
            return true;
        }
        catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }

    }

    @Override
    public boolean updateWithoutPassword(UserModel userDTO) {
        try {
           int result = userRepository.updateUser(userDTO.getPk(), userDTO.getUsername(), userDTO.getLastName(), userDTO.getFirstName(), userDTO.getEmail(), userDTO.getPhoneNumber(), userDTO.getImages());
           userRepository.flush();
            return result >= 0;
        }
        catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public boolean updateEnable(int pk, boolean enable) {
        try {
            int result = userRepository.setStatus(pk, enable);
            userRepository.flush();
            return result >= 0;
        }
        catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<UserModel> getUserByRole(int number) {
     if (number == 1)  return userRepository.findStaff(); else return userRepository.findCustomer();
    }
}

package com.rgbmovie.api;

import java.util.List;
import java.util.stream.Collectors;

import com.rgbmovie.dto.UserDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rgbmovie.model.UserModel;
import com.rgbmovie.service.UserService;

import jakarta.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/api/test")
public class TestApi {
	@Autowired
	private UserService userService;
	@Autowired
	private ModelMapper modelMapper;
	@GetMapping("")
	@RolesAllowed("CUSTOMER")
	public List<UserDTO> testOk() {
		return userService.getAll().stream().map(user -> modelMapper.map(user, UserDTO.class)).collect(Collectors.toList());
	}
	
	@GetMapping("/customer")
	@RolesAllowed("CUSTOMER")
	public String testCus() {
		return "Cyka";
	}
}

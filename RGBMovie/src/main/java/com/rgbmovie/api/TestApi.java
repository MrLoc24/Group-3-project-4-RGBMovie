package com.rgbmovie.api;

import java.util.List;

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
	UserService userService;
	@GetMapping("")
	@RolesAllowed("ADMIN")
	public List<UserModel> testOk() {
		return userService.getAll();
	}
	
	@GetMapping("/customer")
	@RolesAllowed("ADMIN")
	public String testCus() {
		return "Cyka";
	}
}

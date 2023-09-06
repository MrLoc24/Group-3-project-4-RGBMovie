package com.rgbmovie.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestPermit {
	@GetMapping
	public String test() {
		return "Ok";
	}
}

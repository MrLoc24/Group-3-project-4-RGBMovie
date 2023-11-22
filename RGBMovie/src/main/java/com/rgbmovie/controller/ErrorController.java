package com.rgbmovie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/403")
public class ErrorController {
    @GetMapping
    public String error() {
        return "error/403";
    }
}

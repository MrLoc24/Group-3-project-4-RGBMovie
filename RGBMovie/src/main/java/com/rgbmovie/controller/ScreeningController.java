package com.rgbmovie.controller;

import com.rgbmovie.service.ScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/screening")
public class ScreeningController {
    @Autowired
    private ScreeningService screeningService;

    @RequestMapping("/{id}")
    @GetMapping
    public String deleteScreening(@PathVariable("id") int id, @RequestHeader String referer, Model model) {
        String result = screeningService.delete(id);
        if (result != null) {
            model.addAttribute("message", result);
        } else {
            model.addAttribute("message", "Deleted");
        }
        return "redirect:" + referer;
    }
}

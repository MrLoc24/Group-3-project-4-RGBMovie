package com.rgbmovie.controller;

import com.rgbmovie.dto.ReservationDTO;
import com.rgbmovie.dto.UserDTO;
import com.rgbmovie.service.ReservationService;
import com.rgbmovie.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/admin/invoice")
public class InvoiceController {
    @Autowired
    private ReservationService reservationService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserService userService;

    @GetMapping
    public String index(@RequestParam("id") String id, @RequestParam(value = "pk", required = false, defaultValue = "") String pk, Model model) {
        model.addAttribute("invoices", reservationService.getAllByUserId(Integer.parseInt(id)).stream().map(m -> modelMapper.map(m, ReservationDTO.class)).toList());
        if (!"".equals(pk)) {
            model.addAttribute("mapDetail", reservationService.getDetailByUserId(Integer.parseInt(pk)));
            model.addAttribute("user", modelMapper.map(userService.findById(Integer.parseInt(id)), UserDTO.class));
            return "invoice/detail";
        }
        return "invoice/index";
    }
}

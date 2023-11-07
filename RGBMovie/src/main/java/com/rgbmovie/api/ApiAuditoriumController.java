package com.rgbmovie.api;

import com.rgbmovie.dto.AuditoriumDTO;
import com.rgbmovie.service.AuditoriumService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/auditorium")
public class ApiAuditoriumController {
    @Autowired
    private AuditoriumService auditoriumService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/{id}")
    public Object getById(@PathVariable("id") int id) {
        AuditoriumDTO auditoriumDTO = modelMapper.map(auditoriumService.getById(id), AuditoriumDTO.class);
        return auditoriumDTO != null ? new ResponseEntity<>(auditoriumDTO, HttpStatus.OK) : new ResponseEntity<>("No Auditorium", HttpStatus.NO_CONTENT);
    }
}

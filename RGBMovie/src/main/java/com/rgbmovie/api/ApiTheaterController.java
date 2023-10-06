package com.rgbmovie.api;

import com.rgbmovie.dto.TheaterDTO;
import com.rgbmovie.service.TheaterService;
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
@RequestMapping("/api/theater")
public class ApiTheaterController {
    @Autowired
    private TheaterService theaterService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/")
    public Object getAll() {
        List<TheaterDTO> theaterDTO = theaterService.getAll().stream().map(m -> modelMapper.map(m, TheaterDTO.class)).toList();
        return theaterDTO != null ? new ResponseEntity<>(theaterDTO, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public Object getById(@PathVariable("id") int theaterId) {
        TheaterDTO theaterDTO = modelMapper.map(theaterService.getById(theaterId), TheaterDTO.class);
        return theaterDTO != null ? new ResponseEntity<>(theaterDTO, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

package com.rgbmovie.api;

import com.rgbmovie.dto.MovieDTO;
import com.rgbmovie.service.MovieService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ApiMovieController {
    @Autowired
    private MovieService movieService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/movie")
    public Object getAll() {
        return movieService.getAll() != null ? new ResponseEntity<>(movieService.getAll().stream().map(m -> modelMapper.map(m, MovieDTO.class)).toList(), HttpStatus.OK) : new ResponseEntity<>("No data", HttpStatus.NO_CONTENT);
    }

    @GetMapping("/movie/{id}")
    public Object getById(@PathVariable("id") int id) {
        return movieService.getById(id) != null ? new ResponseEntity<>(modelMapper.map(movieService.getById(id), MovieDTO.class), HttpStatus.OK) : new ResponseEntity<>("No data", HttpStatus.NO_CONTENT);
    }
}

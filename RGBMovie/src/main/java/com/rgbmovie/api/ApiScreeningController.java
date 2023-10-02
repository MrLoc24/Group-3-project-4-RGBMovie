package com.rgbmovie.api;

import com.rgbmovie.dto.ScreeningDTO;
import com.rgbmovie.service.ScreeningService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ApiScreeningController {
    @Autowired
    private ScreeningService screeningService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/screening")
    public Object getAllByMovieAndTheater(@RequestParam("movie") int movie, @RequestParam("theater") int theater) {
        return screeningService.getAllActiveByMovie(movie, theater) != null ?
                new ResponseEntity<>(screeningService.getAllActiveByMovie(movie, theater).stream().map(m -> modelMapper.map(m, ScreeningDTO.class)).collect(Collectors.toList()), HttpStatus.OK) : new ResponseEntity<>("No screening", HttpStatus.NO_CONTENT);
    }

}

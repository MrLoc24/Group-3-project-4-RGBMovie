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
    public Object getAllByMovieAndTheater(@RequestParam(value = "movie", defaultValue = "", required = false) Integer movie, @RequestParam("theater") Integer theater) {
        if (movie == null) {
            var result = screeningService.getAllToDay().stream().map(m -> modelMapper.map(m, ScreeningDTO.class)).toList();
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        var result = screeningService.getAllActiveByMovieAndTheater(movie, theater).stream().map(m -> modelMapper.map(m, ScreeningDTO.class)).toList();
        return !result.isEmpty() ?
                new ResponseEntity<>(result, HttpStatus.OK) : new ResponseEntity<>("No screening", HttpStatus.NO_CONTENT);
    }

}

package com.rgbmovie.api;

import com.rgbmovie.dto.AuditoriumDTO;
import com.rgbmovie.model.ScreeningModel;
import com.rgbmovie.service.AuditoriumService;
import com.rgbmovie.service.ScreeningService;
import com.rgbmovie.service.SeatService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/auditorium")
public class ApiAuditoriumController {
    @Autowired
    private AuditoriumService auditoriumService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ScreeningService screeningService;
    @Autowired
    private SeatService seatService;

    @GetMapping

    public Object getById(@PathVariable("id") int id) {
        ScreeningModel screeningModel = screeningService.getbyId(id);
        AuditoriumDTO auditoriumDTO = modelMapper.map(auditoriumService.getById(screeningModel.getAuditorium()), AuditoriumDTO.class);

        Map<String, Object> result = new HashMap<>();
        result.put("Audi", auditoriumDTO);
        result.put("Seat", seatService.seatPaid(id));

        return !result.isEmpty() ? new ResponseEntity<>(result, HttpStatus.OK) : new ResponseEntity<>("No Auditorium", HttpStatus.NO_CONTENT);
    }
}

package com.rgbmovie.api;


import com.rgbmovie.dto.ReservedSeatDTO;
import com.rgbmovie.model.ReservationModel;
import com.rgbmovie.model.ReservedSeatModel;
import com.rgbmovie.service.ReservationService;
import com.rgbmovie.service.ReservedSeatService;
import com.rgbmovie.service.SeatService;
import com.rgbmovie.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("/api/customer")
public class ApiBookingController {
    @Autowired
    private UserService userService;
    @Autowired
    private ReservationService reservationService;
    @Autowired
    private SeatService seatService;
    @Autowired
    private ReservedSeatService reservedSeatService;

    @Autowired
    private ModelMapper modelMapper;


    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public Object booking(@RequestParam("username") String username, @RequestParam("screening") int screening, @RequestParam("price") float price, @RequestParam("seatName") String[] seatName, @RequestParam("auditorium") int auditorium) {
        try {
            ReservationModel reservationModel = reservationService.checkExistIfNotCreateNew(screening);
            reservationModel.setUser(userService.findByUsername(username).getPk());
            reservationModel.setTotalCost(reservationModel.getTotalCost() + price);
            reservationService.update(reservationModel);
            for (String seat : seatName) {
                ReservedSeatDTO reservedSeatDTO = new ReservedSeatDTO();
                reservedSeatDTO.setSeat(seatService.findBySeatNameAndAuditorium(auditorium, seat));
                reservedSeatDTO.setReservation(reservationModel.getPk());
                reservedSeatDTO.setScreening(screening);
                reservedSeatService.createNew(modelMapper.map(reservedSeatDTO, ReservedSeatModel.class));
            }
            return new ResponseEntity<>("You order have been placed successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}

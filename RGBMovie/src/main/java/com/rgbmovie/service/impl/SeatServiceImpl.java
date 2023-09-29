package com.rgbmovie.service.impl;

import com.rgbmovie.model.SeatModel;
import com.rgbmovie.repository.SeatRepository;
import com.rgbmovie.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatServiceImpl implements SeatService {
    @Autowired
    private SeatRepository seatRepository;

    @Override
    public List<SeatModel> getAll() {
        return seatRepository.findAll();
    }

    @Override
    public int findBySeatNameAndAuditorium(int au, String seat) {
        return seatRepository.findBySeatNameAndAuditorium(seat, au).getPk();
    }

}

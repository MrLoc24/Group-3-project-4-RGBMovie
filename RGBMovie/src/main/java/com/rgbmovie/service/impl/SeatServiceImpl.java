package com.rgbmovie.service.impl;

import com.rgbmovie.model.AuditoriumModel;
import com.rgbmovie.model.SeatModel;
import com.rgbmovie.repository.SeatRepository;
import com.rgbmovie.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public List<SeatModel> findByAuditorium(int au) {
        return seatRepository.findByAuditorium(au);
    }

    @Override
    public void addNewSeat(AuditoriumModel auditoriumModel) {
        StringBuilder seat = new StringBuilder();
        List<SeatModel> mapSeat = new ArrayList<>();
        //Add seat with number of row and column, name like row + column with row is chr and column is number
        for (int r = 0; r < auditoriumModel.getRow(); r++) {
            for (int c = 0; c < auditoriumModel.getColumn(); c++) {
                SeatModel seatModel = new SeatModel();
                seatModel.setAuditorium(auditoriumModel.getPk());
                seat.setLength(0); // clear the StringBuilder
                seat.append((char) ('A' + r));
                seat.append(c + 1);
                seatModel.setSeatName(seat.toString());
                mapSeat.add(seatModel);
            }
        }
        seatRepository.saveAllAndFlush(mapSeat);
    }


}

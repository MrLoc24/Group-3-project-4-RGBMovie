package com.rgbmovie.service;

import com.rgbmovie.model.AuditoriumModel;
import com.rgbmovie.model.SeatModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SeatService {
    List<SeatModel> getAll();

    int findBySeatNameAndAuditorium(int au, String seat);

    List<SeatModel> findByAuditorium(int au);

    //Using row and column to create seat
    void addNewSeat(AuditoriumModel auditoriumModel);
}

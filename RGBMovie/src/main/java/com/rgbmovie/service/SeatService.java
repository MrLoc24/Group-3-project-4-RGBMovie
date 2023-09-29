package com.rgbmovie.service;

import com.rgbmovie.model.SeatModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SeatService {
    List<SeatModel> getAll();

    int findBySeatNameAndAuditorium(int au, String seat);
}

package com.rgbmovie.repository;

import com.rgbmovie.model.SeatModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends JpaRepository<SeatModel, Integer> {
    SeatModel findBySeatNameAndAuditorium(String seat, int au);
}

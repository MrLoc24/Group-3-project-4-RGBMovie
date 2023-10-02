package com.rgbmovie.repository;

import com.rgbmovie.model.SeatModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<SeatModel, Integer> {
    SeatModel findBySeatNameAndAuditorium(String seat, int au);

    List<SeatModel> findByAuditorium(int au);
}

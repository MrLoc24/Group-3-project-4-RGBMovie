package com.rgbmovie.repository;

import com.rgbmovie.model.ReservedSeatModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservedSeatRepository extends JpaRepository<ReservedSeatModel, Integer> {
    List<ReservedSeatModel> findByReservation(int id);
}

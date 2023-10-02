package com.rgbmovie.repository;

import com.rgbmovie.model.ScreeningModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ScreeningRepository extends JpaRepository<ScreeningModel, Integer> {
    //Get all screening for upcoming movie
    @Query("SELECT s FROM ScreeningModel s WHERE s.time > :currentTime AND s.movie = :id AND s.theater = :pk")
    List<ScreeningModel> getActiveScreening(@Param("currentTime") Date currentTime, @Param("id") int id, @Param("pk") int pk);
}

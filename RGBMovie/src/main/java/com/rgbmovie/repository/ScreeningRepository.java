package com.rgbmovie.repository;

import com.rgbmovie.model.ScreeningModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ScreeningRepository extends JpaRepository<ScreeningModel, Integer> {
    //Get all screening for upcoming movie
    @Query("SELECT s FROM ScreeningModel s WHERE s.time > :currentTime AND s.movie = :id AND s.theater = :pk")
    List<ScreeningModel> getActiveScreeningByTheaterAndMovie(@Param("currentTime") LocalDateTime currentTime, @Param("id") int id, @Param("pk") int pk);

    List<ScreeningModel> findByTheater(int id);

    List<ScreeningModel> findByAuditorium(int id);

    @Query("SELECT s FROM ScreeningModel s JOIN MovieModel m ON s.movie = m.pk JOIN AuditoriumModel a ON s.auditorium = a.pk WHERE s.theater = :id")
    List<Object> getDetail(@Param("id") int theater);

    @Query("SELECT s FROM ScreeningModel s WHERE s.time > :currentTime ")
    List<ScreeningModel> getActiveScreening(@Param("currentTime") LocalDateTime currentTime);

    @Query("SELECT s FROM ScreeningModel s WHERE DATE(s.time) = :time AND s.movie = :movie")
    List<ScreeningModel> getAllByTime(@Param("time") LocalDate time, @Param("movie") int movie);

    @Query("SELECT s FROM ScreeningModel s WHERE DATE(s.time) = CURRENT_DATE AND s.time > CURRENT_TIME")
    List<ScreeningModel> getAllToDay();
}

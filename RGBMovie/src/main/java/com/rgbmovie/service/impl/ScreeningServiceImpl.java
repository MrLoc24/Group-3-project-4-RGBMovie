package com.rgbmovie.service.impl;

import com.rgbmovie.model.MovieModel;
import com.rgbmovie.model.ScreeningModel;
import com.rgbmovie.repository.MovieRepository;
import com.rgbmovie.repository.ScreeningRepository;
import com.rgbmovie.service.ScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ScreeningServiceImpl implements ScreeningService {
    @Autowired
    private ScreeningRepository screeningRepository;
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<ScreeningModel> getAllActiveByMovieAndTheater(Integer id, Integer pk) {
        return id != null && pk != null ? screeningRepository.getActiveScreeningByTheaterAndMovie(LocalDateTime.now(), id, pk) : screeningRepository.getActiveScreening(LocalDateTime.now());
    }

    @Override
    public List<ScreeningModel> getAllByTheater(int id) {
        return screeningRepository.findByTheater(id);
    }

    @Override
    public List<ScreeningModel> getAllByAuditorium(int id) {
        return screeningRepository.findByAuditorium(id);
    }

    @Override
    public List<ScreeningModel> getAll() {
        return screeningRepository.findAll();
    }

    @Override
    public void addNewScreening(ScreeningModel screeningModel) {
        LocalTime openTime = LocalTime.of(9, 0);
        LocalTime closeTime = LocalTime.of(23, 0);
        List<ScreeningModel> screeningModelList = new ArrayList<>();
        System.out.println(screeningModel.getTime());
        LocalDateTime currentTime = screeningModel.getTime().with(openTime);
        System.out.println(currentTime);
        MovieModel movie = movieRepository.getReferenceById(screeningModel.getMovie());
        // No more movies can be scheduled today
        while (!currentTime.plusMinutes(movie.getDurationMin()).isAfter(screeningModel.getTime().with(closeTime))) {
            int roundedDuration = Math.round(movie.getDurationMin() / 10.0f) * 10;
            ScreeningModel sc = new ScreeningModel();
            sc.setAuditorium(screeningModel.getAuditorium());
            sc.setMovie(screeningModel.getMovie());
            sc.setTheater(screeningModel.getTheater());
            sc.setTime(currentTime);
            screeningModelList.add(sc);
            currentTime = currentTime.plusMinutes(roundedDuration + 10);
            System.out.println(screeningModelList.size());
        }
        screeningRepository.saveAllAndFlush(screeningModelList);
    }

    @Override
    public List<ScreeningModel> getAllByTime(LocalDate time, int movie) {
        return screeningRepository.getAllByTime(time, movie);
    }

    @Override
    public String delete(int id) {
        try {
            screeningRepository.deleteById(id);
            return null;
        } catch (DataAccessException e) {
            // Handle exception here
            return "Error occurred while deleting record";
        }
    }

    @Override
    public List<ScreeningModel> getAllToDay() {
        return screeningRepository.getAllToDay();
    }

    @Override
    public ScreeningModel getbyId(int id) {
        return screeningRepository.getReferenceById(id);
    }
}

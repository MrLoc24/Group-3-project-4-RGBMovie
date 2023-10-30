package com.rgbmovie.service;

import com.rgbmovie.model.ScreeningModel;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface ScreeningService {
    List<ScreeningModel> getAllActiveByMovie(Integer id, Integer pk);

    List<ScreeningModel> getAllByTheater(int id);

    List<ScreeningModel> getAllByAuditorium(int id);

    List<ScreeningModel> getAll();

    void addNewScreening(ScreeningModel screeningModel);

    List<ScreeningModel> getAllByTime(LocalDate time, int movie);
}

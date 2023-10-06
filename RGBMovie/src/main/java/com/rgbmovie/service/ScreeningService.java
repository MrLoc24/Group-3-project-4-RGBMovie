package com.rgbmovie.service;

import com.rgbmovie.model.ScreeningModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ScreeningService {
    List<ScreeningModel> getAllActiveByMovie(int id, int pk);

    List<ScreeningModel> getAllByTheater(int id);

    List<ScreeningModel> getAllByAuditorium(int id);
}

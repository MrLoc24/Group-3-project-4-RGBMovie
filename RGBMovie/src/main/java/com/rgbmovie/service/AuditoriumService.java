package com.rgbmovie.service;

import com.rgbmovie.model.AuditoriumModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuditoriumService {
    List<AuditoriumModel> getAll();

    List<AuditoriumModel> getByTheater(int theater);

    AuditoriumModel getById(int id);
}

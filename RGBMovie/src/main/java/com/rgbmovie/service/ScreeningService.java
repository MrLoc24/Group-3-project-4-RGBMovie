package com.rgbmovie.service;

import com.rgbmovie.model.ScreeningModel;

import java.util.List;

public interface ScreeningRepository {
    List<ScreeningModel> getAllActive();
}

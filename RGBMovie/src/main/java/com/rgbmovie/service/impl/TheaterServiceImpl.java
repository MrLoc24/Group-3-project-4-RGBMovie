package com.rgbmovie.service.impl;

import com.rgbmovie.model.TheaterModel;
import com.rgbmovie.repository.TheaterRepository;
import com.rgbmovie.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TheaterServiceImpl implements TheaterService {
    @Autowired
    private TheaterRepository theaterRepository;
    @Override
    public List<TheaterModel> getAll() {
        return theaterRepository.findAll();
    }
}

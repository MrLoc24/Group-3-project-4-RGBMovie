package com.rgbmovie.service.impl;

import com.rgbmovie.model.ScreeningModel;
import com.rgbmovie.repository.ScreeningRepository;
import com.rgbmovie.service.ScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ScreeningServiceImpl implements ScreeningService {
    @Autowired
    private ScreeningRepository screeningRepository;

    @Override
    public List<ScreeningModel> getAllActiveByMovie(int id, int pk) {
        return screeningRepository.getActiveScreening(new Date(), id, pk);
    }

    @Override
    public List<ScreeningModel> getAllByTheater(int id) {
        return screeningRepository.findByTheater(id);
    }

    @Override
    public List<ScreeningModel> getAllByAuditorium(int id) {
        return screeningRepository.findByAuditorium(id);
    }
}

package com.rgbmovie.service.impl;

import com.rgbmovie.model.CastModel;
import com.rgbmovie.repository.CastRepository;
import com.rgbmovie.service.CastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CastServiceImpl implements CastService {
    @Autowired
    private CastRepository castRepository;

    @Override
    public List<CastModel> getAll() {
        return castRepository.findAll();
    }
}

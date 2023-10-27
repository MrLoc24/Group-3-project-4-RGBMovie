package com.rgbmovie.service.impl;

import com.rgbmovie.model.DirectorModel;
import com.rgbmovie.repository.DirectorRepository;
import com.rgbmovie.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorServiceImpl implements DirectorService {
    @Autowired
    private DirectorRepository directorRepository;

    @Override
    public List<DirectorModel> getAll() {
        return directorRepository.findAll();
    }
}

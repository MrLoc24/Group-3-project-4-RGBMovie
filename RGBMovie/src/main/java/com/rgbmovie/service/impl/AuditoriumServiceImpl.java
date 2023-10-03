package com.rgbmovie.service.impl;

import com.rgbmovie.model.AuditoriumModel;
import com.rgbmovie.repository.AuditoriumRepository;
import com.rgbmovie.service.AuditoriumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditoriumServiceImpl implements AuditoriumService {
    @Autowired
    private AuditoriumRepository auditoriumRepository;

    @Override
    public List<AuditoriumModel> getAll() {
        return auditoriumRepository.findAll();
    }

    @Override
    public List<AuditoriumModel> getByTheater(int theater) {
        return auditoriumRepository.findByTheater(theater);
    }

    @Override
    public AuditoriumModel getById(int id) {
        return auditoriumRepository.getReferenceById(id);
    }

    @Override
    public AuditoriumModel addNew(AuditoriumModel auditoriumModel) {
        return auditoriumRepository.saveAndFlush(auditoriumModel);
    }
}

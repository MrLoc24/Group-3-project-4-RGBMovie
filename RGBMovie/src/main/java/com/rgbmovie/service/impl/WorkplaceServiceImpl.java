package com.rgbmovie.service.impl;

import com.rgbmovie.model.WorkplaceModel;
import com.rgbmovie.repository.WorkplaceRepository;
import com.rgbmovie.service.WorkplaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkplaceServiceImpl implements WorkplaceService {
    @Autowired
    private WorkplaceRepository workplaceRepository;

    @Override
    public List<WorkplaceModel> getAllByTheaterId(int id) {
        return workplaceRepository.findByTheaterId(id);
    }

    @Override
    public void addNewWorker(WorkplaceModel workplaceModel) {
        workplaceRepository.saveAndFlush(workplaceModel);
    }
}

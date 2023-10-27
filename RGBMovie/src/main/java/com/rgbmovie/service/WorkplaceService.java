package com.rgbmovie.service;

import com.rgbmovie.model.WorkplaceModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WorkplaceService {
    List<WorkplaceModel> getAllByTheaterId(int id);

    void addNewWorker(WorkplaceModel workplaceModel);
}

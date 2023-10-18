package com.rgbmovie.service;

import com.rgbmovie.model.TheaterModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TheaterService {
    List<TheaterModel> getAll();

    TheaterModel getById(int pk);

    int numberOfStaff(int pk);

    TheaterModel addNew(TheaterModel theaterModel);

    void deleteTheater(int id);
}

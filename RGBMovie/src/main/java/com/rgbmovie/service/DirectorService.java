package com.rgbmovie.service;

import com.rgbmovie.model.DirectingModel;
import com.rgbmovie.model.DirectorModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface DirectorService {
    List<DirectorModel> getAll();

    String addNew(DirectorModel directorModel, List<Integer> movieId);

    List<DirectorModel> getAllFilmDrirect();

    DirectorModel getById(int id);

    String edit(DirectorModel directorModel);

    String deleteMovie(int id);

    String delete(int id);

    String addNewMovie(int id, List<Integer> movieId);
}

package com.rgbmovie.service;

import com.rgbmovie.model.MovieModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieService {
    List<MovieModel> getAll();

    MovieModel getById(int id);

    MovieModel addNew(MovieModel movieModel);

    List<MovieModel> getAllNotHaveDirector();

    List<MovieModel> getAllNotCast();

    void deleteMovie(int id);
}

package com.rgbmovie.service.impl;

import com.rgbmovie.model.MovieModel;
import com.rgbmovie.repository.MovieRepository;
import com.rgbmovie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<MovieModel> getAll() {
        return movieRepository.findAll();
    }

    @Override
    public MovieModel getById(int id) {
        return movieRepository.getReferenceById(id);
    }

    @Override
    public MovieModel addNew(MovieModel movieModel) {
        return movieRepository.saveAndFlush(movieModel);
    }

    @Override
    public List<MovieModel> getAllNotHaveDirector() {
        return movieRepository.findAllNotHaveDirector();
    }

    @Override
    public List<MovieModel> getAllNotCast() {
        return movieRepository.findAllNotCast();
    }

    @Override
    public void deleteMovie(int id) {
        movieRepository.deleteById(id);
    }


}

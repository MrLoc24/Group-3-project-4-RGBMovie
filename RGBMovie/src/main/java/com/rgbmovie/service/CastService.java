package com.rgbmovie.service;

import com.rgbmovie.model.CastModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CastService {
    List<CastModel> getAllFilmCast();

    List<CastModel> getAll();

    String addNew(CastModel castModel, List<Integer> movie);

    CastModel getById(int id);

    String edit(CastModel castModel);

    String delete(int id);

}

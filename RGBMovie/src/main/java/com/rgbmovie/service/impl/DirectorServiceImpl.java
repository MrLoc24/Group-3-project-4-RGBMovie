package com.rgbmovie.service.impl;

import com.rgbmovie.model.DirectingModel;
import com.rgbmovie.model.DirectorModel;
import com.rgbmovie.repository.DirectingRepository;
import com.rgbmovie.repository.DirectorRepository;
import com.rgbmovie.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DirectorServiceImpl implements DirectorService {
    @Autowired
    private DirectorRepository directorRepository;

    @Autowired
    private DirectingRepository directingRepository;

    @Override
    public List<DirectorModel> getAll() {
        return directorRepository.findAll();
    }

    @Override
    public String addNew(DirectorModel directorModel, List<Integer> movieId) {
        try {
            DirectorModel result = directorRepository.saveAndFlush(directorModel);
            List<DirectingModel> directingModels = new ArrayList<>();
            for (Integer movie : movieId) {
                DirectingModel directingModel = new DirectingModel();
                directingModel.setDirector(result.getPk());
                directingModel.setMovie(movie);
                directingModels.add(directingModel);
            }
            System.out.println(directingModels);
            directingRepository.saveAllAndFlush(directingModels);
            return "Add success";
        } catch (DataAccessException e) {
            return e.toString();
        }
    }

    @Override
    public List<DirectorModel> getAllFilmDrirect() {
        List<DirectorModel> result = directorRepository.findAll();
        System.out.println(result);
        for (DirectorModel directorModel : result
        ) {
            List<DirectingModel> directingModelList = directingRepository.findByDirector(directorModel.getPk());
            directorModel.setDirectingsByPk(directingModelList);
        }
        return result;
    }

    @Override
    public DirectorModel getById(int id) {
        List<DirectingModel> directingModelList = directingRepository.findByDirector(id);
        DirectorModel result = directorRepository.getReferenceById(id);
        result.setDirectingsByPk(directingModelList);
        return result;
    }

    @Override
    public String edit(DirectorModel directorModel) {
        try {
            DirectorModel result = directorRepository.saveAndFlush(directorModel);
            if (result != null) {
                return "Edit success";
            }
            return "Failed";
        } catch (DataAccessException e) {
            return e.toString();
        }
    }
}

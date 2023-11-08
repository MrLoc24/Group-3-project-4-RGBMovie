package com.rgbmovie.service.impl;

import com.rgbmovie.model.CastModel;
import com.rgbmovie.model.CastingModel;
import com.rgbmovie.model.DirectingModel;
import com.rgbmovie.model.DirectorModel;
import com.rgbmovie.repository.CastRepository;
import com.rgbmovie.repository.CastingRepository;
import com.rgbmovie.service.CastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CastServiceImpl implements CastService {
    @Autowired
    private CastRepository castRepository;
    @Autowired
    private CastingRepository castingRepository;

    @Override
    public List<CastModel> getAllFilmCast() {
        List<CastModel> result = castRepository.findAll();
        for (CastModel castModel : result
        ) {
            List<CastingModel> castingModelList = castingRepository.findByActor(castModel.getPk());
            castModel.setCastingsByPk(castingModelList);
        }
        return result;
    }

    @Override
    public List<CastModel> getAll() {
        return castRepository.findAll();
    }

    @Override
    public String addNew(CastModel castModel, List<Integer> movie) {
        try {
            CastModel result = castRepository.saveAndFlush(castModel);
            List<CastingModel> castingModels = new ArrayList<>();
            for (Integer id : movie) {
                CastingModel castingModel = new CastingModel();
                castingModel.setMovie(id);
                castingModel.setActor(result.getPk());
                castingModels.add(castingModel);
            }
            castingRepository.saveAllAndFlush(castingModels);
            return "Add success";
        } catch (DataAccessException e) {
            return e.toString();
        }
    }

    @Override
    public CastModel getById(int id) {
        return castRepository.getReferenceById(id);
    }

    @Override
    public String edit(CastModel castModel) {
        try {
            castRepository.saveAndFlush(castModel);
            return "Success";
        } catch (DataAccessException e) {
            return e.toString();
        }
    }

    @Override
    public String deleteMovie(int id) {
        try {
            castingRepository.deleteById(id);
            return "Deleted";
        } catch (DataAccessException e) {
            return e.toString();
        }
    }

    @Override
    public String delete(int id) {
        try {
            castRepository.deleteById(id);
            return "Deleted";
        } catch (DataAccessException e) {
            return e.toString();
        }
    }
}

package com.rgbmovie.service.impl;

import com.rgbmovie.model.CastModel;
import com.rgbmovie.model.CastingModel;
import com.rgbmovie.model.DirectingModel;
import com.rgbmovie.model.DirectorModel;
import com.rgbmovie.repository.CastRepository;
import com.rgbmovie.repository.CastingRepository;
import com.rgbmovie.service.CastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        System.out.println(result);
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
}

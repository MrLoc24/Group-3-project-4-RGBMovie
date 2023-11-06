package com.rgbmovie.repository;

import com.rgbmovie.model.CastingModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CastingRepository extends JpaRepository<CastingModel, Integer> {
    List<CastingModel> findByActor(int id);
}

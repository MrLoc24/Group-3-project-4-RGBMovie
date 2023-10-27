package com.rgbmovie.repository;

import com.rgbmovie.model.CastModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CastRepository extends JpaRepository<CastModel, Integer> {
}

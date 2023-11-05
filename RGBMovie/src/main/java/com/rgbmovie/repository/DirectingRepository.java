package com.rgbmovie.repository;

import com.rgbmovie.model.DirectingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DirectingRepository extends JpaRepository<DirectingModel, Integer> {
    List<DirectingModel> findByDirector(int id);
}

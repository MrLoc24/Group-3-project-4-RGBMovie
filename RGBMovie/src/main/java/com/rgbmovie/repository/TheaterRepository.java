package com.rgbmovie.repository;

import com.rgbmovie.model.TheaterModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterRepository extends JpaRepository<TheaterModel, Integer> {
}

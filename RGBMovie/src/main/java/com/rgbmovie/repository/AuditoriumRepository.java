package com.rgbmovie.repository;

import com.rgbmovie.model.AuditoriumModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditoriumRepository extends JpaRepository<AuditoriumModel, Integer> {
}

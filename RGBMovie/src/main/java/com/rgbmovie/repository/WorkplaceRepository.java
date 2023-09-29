package com.rgbmovie.repository;

import com.rgbmovie.model.WorkplaceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkplaceRepository extends JpaRepository<WorkplaceModel, Integer> {
}

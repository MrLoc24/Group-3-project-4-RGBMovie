package com.rgbmovie.repository;

import com.rgbmovie.model.WorkplaceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkplaceRepository extends JpaRepository<WorkplaceModel, Integer> {

    List<WorkplaceModel> findByTheaterId(int id);

}

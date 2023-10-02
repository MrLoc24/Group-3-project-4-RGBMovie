package com.rgbmovie.repository;

import com.rgbmovie.model.AuditoriumModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuditoriumRepository extends JpaRepository<AuditoriumModel, Integer> {

    List<AuditoriumModel> findByTheater(int au);
}

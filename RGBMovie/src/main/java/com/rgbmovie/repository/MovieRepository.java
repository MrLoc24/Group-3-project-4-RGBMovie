package com.rgbmovie.repository;

import com.rgbmovie.model.MovieModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<MovieModel, Integer> {

    @Query("SELECT m FROM MovieModel m LEFT JOIN DirectingModel d ON m.pk = d.movie WHERE d.movie IS NULL ")
    List<MovieModel> findAllNotHaveDirector();
}

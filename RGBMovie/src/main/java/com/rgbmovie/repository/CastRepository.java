package com.rgbmovie.repository;

import com.rgbmovie.model.CastModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface CastRepository extends JpaRepository<CastModel, Integer> {
    @Query("SELECT c FROM CastModel c JOIN CastingModel ct ON c.pk = ct.actor JOIN MovieModel m ON ct.movie = m.pk WHERE m.pk = :id")
    List<CastModel> getByMovieId(@Param("id") int id);

}

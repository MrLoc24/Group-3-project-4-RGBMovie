package com.rgbmovie.repository;

import com.rgbmovie.model.TheaterModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterRepository extends JpaRepository<TheaterModel, Integer> {
    @Query("SELECT COUNT(*) FROM TheaterModel m JOIN WorkplaceModel w ON m.pk = w.theaterId WHERE m.pk = :pk")
    int countByWorkplacesByPk(int pk);


}

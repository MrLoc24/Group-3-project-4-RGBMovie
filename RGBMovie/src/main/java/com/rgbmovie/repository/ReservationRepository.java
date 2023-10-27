package com.rgbmovie.repository;

import com.rgbmovie.model.ReservationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationModel, Integer> {
    //Check if already have cart with the screening or not, if not, create new one, or add new seat with the same screening to the cart
    @Query("SELECT r FROM ReservationModel r WHERE r.getPaid = 0 AND r.isActive = 1 AND r.screening = :screening")
    ReservationModel checkExistOrNot(@Param("screening") Integer screening);

    @Query("SELECT r FROM ReservationModel r WHERE r.getPaid = 0 AND r.isActive = 1")
    ReservationModel inCartButNotPay();

    List<ReservationModel> findByUser(int id);
}

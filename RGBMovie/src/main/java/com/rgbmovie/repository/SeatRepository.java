package com.rgbmovie.repository;

import com.rgbmovie.model.SeatModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<SeatModel, Integer> {
    SeatModel findBySeatNameAndAuditorium(String seat, int au);

    List<SeatModel> findByAuditorium(int au);

    @Query("SELECT s FROM SeatModel s JOIN ReservedSeatModel r ON s.pk = r.seat JOIN ScreeningModel sc ON r.screening = sc.pk JOIN ReservationModel re ON re.screening = sc.pk WHERE re.getPaid = 1 AND sc.pk = :id")
    List<SeatModel> seatOccupied(@Param("id") int id);
}

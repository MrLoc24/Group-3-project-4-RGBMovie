package com.rgbmovie.service;

import com.rgbmovie.model.ReservationModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface ReservationService {
	ReservationModel checkExistIfNotCreateNew(int screening);

	ReservationModel update(ReservationModel reservationModel);

	// For Admin to check all order
	List<ReservationModel> getAll();

	ReservationModel getById(int id);

	// For Customer view order history or cart
	List<Map<String, Object>> getAllByUser(int id, String action);

	void deleteReservation(int id);
}

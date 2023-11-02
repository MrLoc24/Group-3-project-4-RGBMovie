package com.rgbmovie.service;

import com.rgbmovie.model.ReservationModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReservationService {
    ReservationModel checkExistIfNotCreateNew(int screening);

    ReservationModel update(ReservationModel reservationModel);

    //    For Admin to check all order
    List<ReservationModel> getAll();

    ReservationModel getById(int id);

    //    For Customer view order history
    List<ReservationModel> getAllByUser(int id);

    List<ReservationModel> getAllByUserNotPay(int id);
}

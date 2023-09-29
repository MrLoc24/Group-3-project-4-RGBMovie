package com.rgbmovie.service.impl;

import com.rgbmovie.model.ReservationModel;
import com.rgbmovie.repository.ReservationRepository;
import com.rgbmovie.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    ReservationRepository reservationRepository;

    @Override
    public ReservationModel checkExistIfNotCreateNew(int screening) {
        ReservationModel checkReservation = reservationRepository.checkExistOrNot(screening);
        if (checkReservation == null) {
            ReservationModel reservationModel = new ReservationModel();
            reservationModel.setScreening(screening);
            return reservationRepository.saveAndFlush(reservationModel);
        }
        return checkReservation;
    }

    @Override
    public ReservationModel update(ReservationModel reservationModel) {
        return reservationRepository.saveAndFlush(reservationModel);
    }
}

package com.rgbmovie.service.impl;

import com.rgbmovie.model.ReservationModel;
import com.rgbmovie.repository.ReservationRepository;
import com.rgbmovie.repository.UserRepository;
import com.rgbmovie.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private UserRepository userRepository;

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

    @Override
    public List<ReservationModel> getAll() {
        return reservationRepository.findAll();
    }

    @Override
    public ReservationModel getById(int id) {
        return reservationRepository.getReferenceById(id);
    }


    @Override
    public List<ReservationModel> getAllByUser(int id) {
        return reservationRepository.findByUser(id);
    }

    @Override
    public List<ReservationModel> getAllByUserNotPay(int id) {
        return reservationRepository.findByUserNotPay(id);
    }


}

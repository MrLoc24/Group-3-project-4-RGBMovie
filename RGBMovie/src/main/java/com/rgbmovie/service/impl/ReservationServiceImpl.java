package com.rgbmovie.service.impl;

import com.rgbmovie.model.ReservationModel;
import com.rgbmovie.model.ReservedSeatModel;
import com.rgbmovie.model.ScreeningModel;
import com.rgbmovie.repository.*;
import com.rgbmovie.service.ReservationService;
import com.rgbmovie.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ScreeningRepository screeningRepository;
    @Autowired
    private ReservedSeatRepository reservedSeatRepository;
    @Autowired
    private TheaterRepository theaterRepository;
    @Autowired
    private AuditoriumRepository auditoriumRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private SeatRepository seatRepository;

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
    public List<Map<String, Object>> getAllByUser(int id, String action) {
        List<Map<String, Object>> finalList = new ArrayList<>();
        List<ReservationModel> reservationModelList = new ArrayList<>();
        Map<String, Object> result = new HashMap<>();
        if (action.equals("cart")) {
            reservationModelList = reservationRepository.findByUserNotPay(id);
        }
        if (action.equals("history")) {
            reservationModelList = reservationRepository.findByUserHistory(id);
        }
        for (ReservationModel reservationModel : reservationModelList) {
            List<String> seatName = new ArrayList<>();
            result.put("Reservation", reservationModel);
            ScreeningModel screeningModel = screeningRepository.getReferenceById(reservationModel.getScreening());
            result.put("Screening", screeningModel);
            List<ReservedSeatModel> reservedSeatModelList = reservedSeatRepository.findByReservation(reservationModel.getPk());
            for (ReservedSeatModel reservedSeatModel : reservedSeatModelList) {
                seatName.add(seatRepository.getReferenceById(reservedSeatModel.getSeat()).getSeatName());
            }
            result.put("Seat", seatName);
            result.put("Theater", theaterRepository.getReferenceById(screeningModel.getTheater()));
            result.put("Auditorium", auditoriumRepository.getReferenceById(screeningModel.getAuditorium()));
            result.put("Movie", movieRepository.getReferenceById(screeningModel.getMovie()));
            finalList.add(result);
        }
        return finalList;
    }


}

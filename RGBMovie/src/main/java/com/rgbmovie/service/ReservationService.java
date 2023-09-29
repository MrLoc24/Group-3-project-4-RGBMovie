package com.rgbmovie.service;

import com.rgbmovie.model.ReservationModel;
import org.springframework.stereotype.Service;

@Service
public interface ReservationService {
    ReservationModel checkExistIfNotCreateNew(int screening);

    ReservationModel update(ReservationModel reservationModel);
}

package com.rgbmovie.service.impl;

import com.rgbmovie.model.ReservationModel;
import org.springframework.stereotype.Service;

@Service
public interface ReservationService {
    ReservationModel checkExistIfNotCreateNew(int screening);
}

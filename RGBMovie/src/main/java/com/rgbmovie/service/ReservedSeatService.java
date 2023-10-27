package com.rgbmovie.service;

import com.rgbmovie.model.ReservedSeatModel;

import java.util.List;

public interface ReservedSeatService {
    ReservedSeatModel createNew(ReservedSeatModel reservedSeatModel);

    ReservedSeatModel findById(int id);

    List<ReservedSeatModel> findByReservationId(int id);

    void cancelSeat(int id);
}

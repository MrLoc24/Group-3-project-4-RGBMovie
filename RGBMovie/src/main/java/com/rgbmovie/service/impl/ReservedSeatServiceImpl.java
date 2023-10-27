package com.rgbmovie.service.impl;

import com.rgbmovie.model.ReservedSeatModel;
import com.rgbmovie.repository.ReservedSeatRepository;
import com.rgbmovie.service.ReservedSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservedSeatServiceImpl implements ReservedSeatService {

    @Autowired
    private ReservedSeatRepository reservedSeatRepository;

    @Override
    public ReservedSeatModel createNew(ReservedSeatModel reservedSeatModel) {
        return reservedSeatRepository.saveAndFlush(reservedSeatModel);
    }

    @Override
    public ReservedSeatModel findById(int id) {
        return reservedSeatRepository.getReferenceById(id);
    }

    //Get order detail
    @Override
    public List<ReservedSeatModel> findByReservationId(int id) {
        return reservedSeatRepository.findByReservation(id);
    }

    @Override
    public void cancelSeat(int id) {
        if (reservedSeatRepository.existsById(id)) {
            reservedSeatRepository.deleteById(id);
        }
    }
}

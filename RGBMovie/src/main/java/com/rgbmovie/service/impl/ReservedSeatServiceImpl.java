package com.rgbmovie.service.impl;

import com.rgbmovie.model.ReservedSeatModel;
import com.rgbmovie.repository.ReservedSeatRepository;
import com.rgbmovie.service.ReservedSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservedSeatServiceImpl implements ReservedSeatService {

    @Autowired
    private ReservedSeatRepository reservedSeatRepository;

    @Override
    public void createNew(ReservedSeatModel reservedSeatModel) {
        reservedSeatRepository.saveAndFlush(reservedSeatModel);
    }
}

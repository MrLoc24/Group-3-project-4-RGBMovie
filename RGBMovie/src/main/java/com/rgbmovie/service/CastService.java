package com.rgbmovie.service;

import com.rgbmovie.model.CastModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CastService {
    List<CastModel> getAll();
}

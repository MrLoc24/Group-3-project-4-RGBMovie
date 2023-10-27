package com.rgbmovie.service;

import com.rgbmovie.model.DirectorModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DirectorService {
    List<DirectorModel> getAll();
}

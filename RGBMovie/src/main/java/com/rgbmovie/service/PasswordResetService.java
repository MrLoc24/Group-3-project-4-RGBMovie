package com.rgbmovie.service;

import com.rgbmovie.model.PasswordResetTokenModel;
import org.springframework.stereotype.Service;

@Service
public interface PasswordResetService {
    void createPasswordResetTokenForUser(PasswordResetTokenModel passwordResetTokenModel);

    String validatePasswordResetToken(String token);
}

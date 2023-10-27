package com.rgbmovie.service.impl;

import com.rgbmovie.model.PasswordResetTokenModel;
import com.rgbmovie.repository.PasswordResetRepository;
import com.rgbmovie.service.PasswordResetService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class PasswordResetServiceImpl implements PasswordResetService {
    @Autowired
    private PasswordResetRepository passwordResetRepository;

    @Override
    public void createPasswordResetTokenForUser(PasswordResetTokenModel passwordResetTokenModel) {
        try {
            passwordResetRepository.saveAndFlush(passwordResetTokenModel);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    @Override
    public String validatePasswordResetToken(String token) {
        final PasswordResetTokenModel passToken = passwordResetRepository.findByToken(token);

        return !isTokenFound(passToken) ? "Invalid"
                : isTokenExpired(passToken) ? "Expired"
                : passToken.getUserId().toString();
    }

    private boolean isTokenFound(PasswordResetTokenModel passToken) {
        return passToken != null;
    }

    private boolean isTokenExpired(@NotNull PasswordResetTokenModel passToken) {
        final Calendar cal = Calendar.getInstance();
        return passToken.getExpiryDate().before(cal.getTime());
    }
}

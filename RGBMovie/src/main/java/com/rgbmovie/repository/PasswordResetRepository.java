package com.rgbmovie.repository;

import com.rgbmovie.model.PasswordResetTokenModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasswordResetRepository extends JpaRepository<PasswordResetTokenModel, Integer> {
    PasswordResetTokenModel findByToken(String token);
}

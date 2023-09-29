package com.rgbmovie.repository;

import com.rgbmovie.model.BankingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankingRepository extends JpaRepository<BankingModel, Integer> {
}

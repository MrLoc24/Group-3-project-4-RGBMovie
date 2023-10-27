package com.rgbmovie.dto;

import com.rgbmovie.model.UserModel;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.Date;

@Data
public class PasswordResetTokenDTO {

    private Long pk;

    private String token;

    private Integer userId;

    private Date expiryDate;
}

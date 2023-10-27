package com.rgbmovie.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;


@Entity
@Data
@Table(name = "PasswordResetToken", schema = "rgb", catalog = "")
public class PasswordResetTokenModel {

    private static final int EXPIRATION = 60;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk")
    private int pk;
    @Basic
    @Column(name = "token")
    private String token;
    @Basic
    @Column(name = "user_id")
    private Integer userId;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "pk", insertable = false, updatable = false)
    private UserModel userByUserId;
    @Basic
    @Column(name = "expiryDate")
    private Date expiryDate;

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }


    public void setExpiryDate() {
        Calendar cal = Calendar.getInstance(); // gets the current date and time
        cal.add(Calendar.MINUTE, EXPIRATION); // adds one hour
        this.expiryDate = cal.getTime();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PasswordResetTokenModel that = (PasswordResetTokenModel) o;
        return pk == that.pk && Objects.equals(token, that.token) && Objects.equals(userId, that.userId) && Objects.equals(expiryDate, that.expiryDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pk, token, expiryDate, userId);
    }
}
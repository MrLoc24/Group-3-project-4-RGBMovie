package com.rgbmovie.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "Banking", schema = "rgb", catalog = "")
public class BankingModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "pk")
    private int pk;
    @Basic
    @Column(name = "time")
    private Timestamp time;
    @Basic
    @Column(name = "reservation_id")
    private Integer reservationId;
    @Basic
    @Column(name = "user_id")
    private Integer userId;
    @ManyToOne
    @JoinColumn(name = "reservation_id", referencedColumnName = "pk")
    private ReservationModel reservationByReservationId;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "pk")
    private UserModel userByUserId;

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Integer getReservationId() {
        return reservationId;
    }

    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankingModel that = (BankingModel) o;
        return pk == that.pk && Objects.equals(time, that.time) && Objects.equals(reservationId, that.reservationId) && Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pk, time, reservationId, userId);
    }

    public ReservationModel getReservationByReservationId() {
        return reservationByReservationId;
    }

    public void setReservationByReservationId(ReservationModel reservationByReservationId) {
        this.reservationByReservationId = reservationByReservationId;
    }

    public UserModel getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserModel userByUserId) {
        this.userByUserId = userByUserId;
    }
}

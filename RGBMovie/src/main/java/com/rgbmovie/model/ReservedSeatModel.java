package com.rgbmovie.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "ReservedSeat", schema = "rgb", catalog = "")
public class ReservedSeatModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "pk")
    private int pk;
    @Basic
    @Column(name = "screening")
    private Integer screening;
    @Basic
    @Column(name = "seat")
    private Integer seat;
    @Basic
    @Column(name = "reservation")
    private Integer reservation;
    @ManyToOne
    @JoinColumn(name = "screening", referencedColumnName = "pk", insertable = false, updatable = false)
    @JsonIgnore
    private ScreeningModel screeningByScreening;
    @ManyToOne
    @JoinColumn(name = "seat", referencedColumnName = "pk", insertable = false, updatable = false)
    @JsonIgnore
    private SeatModel seatBySeat;
    @ManyToOne
    @JoinColumn(name = "reservation", referencedColumnName = "pk", insertable = false, updatable = false)
    @JsonIgnore
    private ReservationModel reservationByReservation;

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public Integer getScreening() {
        return screening;
    }

    public void setScreening(Integer screening) {
        this.screening = screening;
    }

    public Integer getSeat() {
        return seat;
    }

    public void setSeat(Integer seat) {
        this.seat = seat;
    }

    public Integer getReservation() {
        return reservation;
    }

    public void setReservation(Integer reservation) {
        this.reservation = reservation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservedSeatModel that = (ReservedSeatModel) o;
        return pk == that.pk && Objects.equals(screening, that.screening) && Objects.equals(seat, that.seat) && Objects.equals(reservation, that.reservation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pk, screening, seat, reservation);
    }

    public ScreeningModel getScreeningByScreening() {
        return screeningByScreening;
    }

    public void setScreeningByScreening(ScreeningModel screeningByScreening) {
        this.screeningByScreening = screeningByScreening;
    }

    public SeatModel getSeatBySeat() {
        return seatBySeat;
    }

    public void setSeatBySeat(SeatModel seatBySeat) {
        this.seatBySeat = seatBySeat;
    }

    public ReservationModel getReservationByReservation() {
        return reservationByReservation;
    }

    public void setReservationByReservation(ReservationModel reservationByReservation) {
        this.reservationByReservation = reservationByReservation;
    }
}

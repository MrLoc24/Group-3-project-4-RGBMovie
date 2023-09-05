package com.rgbmovie.model;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Reservation", schema = "rgb", catalog = "")
public class ReservationModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "pk")
    private int pk;
    @Basic
    @Column(name = "user")
    private Integer user;
    @Basic
    @Column(name = "screening")
    private Integer screening;
    @Basic
    @Column(name = "is_active")
    private Integer isActive;
    @Basic
    @Column(name = "get_paid")
    private Integer getPaid;
    @Basic
    @Column(name = "total_cost")
    private Double totalCost;
    @OneToMany(mappedBy = "reservationByReservationId")
    private Collection<BankingModel> bankingsByPk;
    @ManyToOne
    @JoinColumn(name = "user", referencedColumnName = "pk", insertable = false, updatable = false)
    private UserModel userByUser;
    @ManyToOne
    @JoinColumn(name = "screening", referencedColumnName = "pk", insertable = false, updatable = false)
    private ScreeningModel screeningByScreening;
    @OneToMany(mappedBy = "reservationByReservation")
    private Collection<ReservedSeatModel> reservedSeatsByPk;

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public Integer getScreening() {
        return screening;
    }

    public void setScreening(Integer screening) {
        this.screening = screening;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public Integer getGetPaid() {
        return getPaid;
    }

    public void setGetPaid(Integer getPaid) {
        this.getPaid = getPaid;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservationModel that = (ReservationModel) o;
        return pk == that.pk && Objects.equals(user, that.user) && Objects.equals(screening, that.screening) && Objects.equals(isActive, that.isActive) && Objects.equals(getPaid, that.getPaid) && Objects.equals(totalCost, that.totalCost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pk, user, screening, isActive, getPaid, totalCost);
    }

    public Collection<BankingModel> getBankingsByPk() {
        return bankingsByPk;
    }

    public void setBankingsByPk(Collection<BankingModel> bankingsByPk) {
        this.bankingsByPk = bankingsByPk;
    }

    public UserModel getUserByUser() {
        return userByUser;
    }

    public void setUserByUser(UserModel userByUser) {
        this.userByUser = userByUser;
    }

    public ScreeningModel getScreeningByScreening() {
        return screeningByScreening;
    }

    public void setScreeningByScreening(ScreeningModel screeningByScreening) {
        this.screeningByScreening = screeningByScreening;
    }

    public Collection<ReservedSeatModel> getReservedSeatsByPk() {
        return reservedSeatsByPk;
    }

    public void setReservedSeatsByPk(Collection<ReservedSeatModel> reservedSeatsByPk) {
        this.reservedSeatsByPk = reservedSeatsByPk;
    }
}

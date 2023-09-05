package com.rgbmovie.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Workplace", schema = "rgb", catalog = "")
public class WorkplaceModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "pk")
    private int pk;
    @Basic
    @Column(name = "user_id")
    private Integer userId;
    @Basic
    @Column(name = "theater_id")
    private Integer theaterId;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "pk", insertable = false, updatable = false)
    private UserModel userByUserId;
    @ManyToOne
    @JoinColumn(name = "theater_id", referencedColumnName = "pk", insertable = false, updatable = false)
    private TheaterModel theaterByTheaterId;

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(Integer theaterId) {
        this.theaterId = theaterId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkplaceModel that = (WorkplaceModel) o;
        return pk == that.pk && Objects.equals(userId, that.userId) && Objects.equals(theaterId, that.theaterId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pk, userId, theaterId);
    }

    public UserModel getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserModel userByUserId) {
        this.userByUserId = userByUserId;
    }

    public TheaterModel getTheaterByTheaterId() {
        return theaterByTheaterId;
    }

    public void setTheaterByTheaterId(TheaterModel theaterByTheaterId) {
        this.theaterByTheaterId = theaterByTheaterId;
    }
}

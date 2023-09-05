package com.rgbmovie.model;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Auditorium", schema = "rgb", catalog = "")
public class AuditoriumModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "pk")
    private int pk;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "seats_no")
    private Integer seatsNo;
    @Basic
    @Column(name = "theater")
    private Integer theater;
    @ManyToOne
    @JoinColumn(name = "theater", referencedColumnName = "pk")
    private TheaterModel theaterByTheater;
    @OneToMany(mappedBy = "auditoriumByAuditorium")
    private Collection<ScreeningModel> screeningsByPk;
    @OneToMany(mappedBy = "auditoriumByAuditorium")
    private Collection<SeatModel> seatsByPk;

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSeatsNo() {
        return seatsNo;
    }

    public void setSeatsNo(Integer seatsNo) {
        this.seatsNo = seatsNo;
    }

    public Integer getTheater() {
        return theater;
    }

    public void setTheater(Integer theater) {
        this.theater = theater;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuditoriumModel that = (AuditoriumModel) o;
        return pk == that.pk && Objects.equals(name, that.name) && Objects.equals(seatsNo, that.seatsNo) && Objects.equals(theater, that.theater);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pk, name, seatsNo, theater);
    }

    public TheaterModel getTheaterByTheater() {
        return theaterByTheater;
    }

    public void setTheaterByTheater(TheaterModel theaterByTheater) {
        this.theaterByTheater = theaterByTheater;
    }

    public Collection<ScreeningModel> getScreeningsByPk() {
        return screeningsByPk;
    }

    public void setScreeningsByPk(Collection<ScreeningModel> screeningsByPk) {
        this.screeningsByPk = screeningsByPk;
    }

    public Collection<SeatModel> getSeatsByPk() {
        return seatsByPk;
    }

    public void setSeatsByPk(Collection<SeatModel> seatsByPk) {
        this.seatsByPk = seatsByPk;
    }
}

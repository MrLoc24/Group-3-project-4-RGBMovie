package com.rgbmovie.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Column(name = "au_name")
    private String name;
    @Basic
    @Column(name = "au_rows")
    private Integer row;

    @Basic
    @Column(name = "au_columns")
    private Integer column;
    @Basic
    @Column(name = "theater")
    private Integer theater;
    @ManyToOne
    @JoinColumn(name = "theater", referencedColumnName = "pk", insertable = false, updatable = false)
    @JsonIgnore
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

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer seatsNo) {
        this.row = seatsNo;
    }

    public Integer getTheater() {
        return theater;
    }

    public void setTheater(Integer theater) {
        this.theater = theater;
    }

    public Integer getColumn() {
        return column;
    }

    public void setColumn(Integer column) {
        this.column = column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuditoriumModel that = (AuditoriumModel) o;
        return pk == that.pk && Objects.equals(name, that.name) && Objects.equals(row, that.row) && Objects.equals(theater, that.theater);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pk, name, row, theater);
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

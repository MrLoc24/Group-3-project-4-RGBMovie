package com.rgbmovie.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Screening", schema = "rgb", catalog = "")
public class ScreeningModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "pk")
    private int pk;
    @Basic
    @Column(name = "movie")
    private int movie;
    @Basic
    @Column(name = "theater")
    private int theater;
    @Basic
    @Column(name = "auditorium")
    private Integer auditorium;
    @Basic
    @Column(name = "time")
    private LocalDateTime time;
    @OneToMany(mappedBy = "screeningByScreening")
    private Collection<ReservationModel> reservationsByPk;
    @OneToMany(mappedBy = "screeningByScreening")
    private Collection<ReservedSeatModel> reservedSeatsByPk;
    @ManyToOne
    @JoinColumn(name = "movie", referencedColumnName = "pk", nullable = false, insertable = false, updatable = false)
    @JsonIgnore
    private MovieModel movieByMovie;
    @ManyToOne
    @JoinColumn(name = "theater", referencedColumnName = "pk", nullable = false, insertable = false, updatable = false)
    @JsonIgnore
    private TheaterModel theaterByTheater;
    @ManyToOne
    @JoinColumn(name = "auditorium", referencedColumnName = "pk", insertable = false, updatable = false)
    @JsonIgnore
    private AuditoriumModel auditoriumByAuditorium;

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public int getMovie() {
        return movie;
    }

    public void setMovie(int movie) {
        this.movie = movie;
    }

    public int getTheater() {
        return theater;
    }

    public void setTheater(int theater) {
        this.theater = theater;
    }

    public Integer getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(Integer auditorium) {
        this.auditorium = auditorium;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScreeningModel that = (ScreeningModel) o;
        return pk == that.pk && movie == that.movie && theater == that.theater && Objects.equals(auditorium, that.auditorium) && Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pk, movie, theater, auditorium, time);
    }

    public Collection<ReservationModel> getReservationsByPk() {
        return reservationsByPk;
    }

    public void setReservationsByPk(Collection<ReservationModel> reservationsByPk) {
        this.reservationsByPk = reservationsByPk;
    }

    public Collection<ReservedSeatModel> getReservedSeatsByPk() {
        return reservedSeatsByPk;
    }

    public void setReservedSeatsByPk(Collection<ReservedSeatModel> reservedSeatsByPk) {
        this.reservedSeatsByPk = reservedSeatsByPk;
    }

    public MovieModel getMovieByMovie() {
        return movieByMovie;
    }

    public void setMovieByMovie(MovieModel movieByMovie) {
        this.movieByMovie = movieByMovie;
    }

    public TheaterModel getTheaterByTheater() {
        return theaterByTheater;
    }

    public void setTheaterByTheater(TheaterModel theaterByTheater) {
        this.theaterByTheater = theaterByTheater;
    }

    public AuditoriumModel getAuditoriumByAuditorium() {
        return auditoriumByAuditorium;
    }

    public void setAuditoriumByAuditorium(AuditoriumModel auditoriumByAuditorium) {
        this.auditoriumByAuditorium = auditoriumByAuditorium;
    }
}

package com.rgbmovie.dto;

import java.time.LocalDateTime;

public class ScreeningDTO {
    private Integer pk;
    private Integer movie;
    private Integer theater;
    private Integer auditorium;
    private LocalDateTime time;

    public Integer getPk() {
        return this.pk;
    }

    public void setPk(Integer pk) {
        this.pk = pk;
    }

    public Integer getMovie() {
        return this.movie;
    }

    public void setMovie(Integer movie) {
        this.movie = movie;
    }

    public Integer getTheater() {
        return this.theater;
    }

    public void setTheater(Integer theater) {
        this.theater = theater;
    }

    public Integer getAuditorium() {
        return this.auditorium;
    }

    public void setAuditorium(Integer auditorium) {
        this.auditorium = auditorium;
    }

    public LocalDateTime getTime() {
        return this.time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}

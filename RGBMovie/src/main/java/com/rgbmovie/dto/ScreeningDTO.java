package com.rgbmovie.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Data
public class ScreeningDTO {
    private Integer pk;
    private Integer movie;
    private Integer theater;
    private Integer auditorium;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date time;

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

    public Date getTime() {
        return this.time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}

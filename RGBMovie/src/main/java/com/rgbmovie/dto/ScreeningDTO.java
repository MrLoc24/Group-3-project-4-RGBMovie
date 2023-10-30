package com.rgbmovie.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;


@Getter
@Data
@Setter
public class ScreeningDTO {
    private Integer pk;
    private Integer movie;
    private Integer theater;
    private Integer auditorium;
    private LocalDateTime time;

    public void setPk(Integer pk) {
        this.pk = pk;
    }

    public void setMovie(Integer movie) {
        this.movie = movie;
    }

    public void setTheater(Integer theater) {
        this.theater = theater;
    }

    public void setAuditorium(Integer auditorium) {
        this.auditorium = auditorium;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}

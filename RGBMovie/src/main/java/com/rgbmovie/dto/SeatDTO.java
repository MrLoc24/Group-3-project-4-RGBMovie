package com.rgbmovie.dto;

import lombok.Data;

@Data
public class SeatDTO {
    private Integer pk;
    private Integer auditorium;
    private String seatName;

    public Integer getPk() {
        return this.pk;
    }

    public void setPk(Integer pk) {
        this.pk = pk;
    }


    public Integer getAuditorium() {
        return this.auditorium;
    }

    public void setAuditorium(Integer auditorium) {
        this.auditorium = auditorium;
    }

    public String getSeatName() {
        return this.seatName;
    }

    public void setSeatName(String seatName) {
        this.seatName = seatName;
    }
}

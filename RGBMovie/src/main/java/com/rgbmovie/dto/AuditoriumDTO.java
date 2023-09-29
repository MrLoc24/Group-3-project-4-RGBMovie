package com.rgbmovie.dto;

import lombok.Data;

@Data
public class AuditoriumDTO {
    private Integer pk;
    private String name;
    private Integer row;
    private Integer theater;
    private Integer column;

    public Integer getColumn() {
        return column;
    }

    public void setColumn(Integer column) {
        this.column = column;
    }

    public Integer getPk() {
        return this.pk;
    }

    public void setPk(Integer pk) {
        this.pk = pk;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRow() {
        return this.row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getTheater() {
        return this.theater;
    }

    public void setTheater(Integer theater) {
        this.theater = theater;
    }
}

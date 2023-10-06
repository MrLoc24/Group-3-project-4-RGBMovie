package com.rgbmovie.dto;

import lombok.Data;

@Data
public class StillcutDTO {
    private Integer pk;
    private Integer movie;
    private String image;

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

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

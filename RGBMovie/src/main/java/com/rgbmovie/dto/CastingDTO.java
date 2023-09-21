package com.rgbmovie.dto;

public class CastingDTO {
    private Integer pk;
    private Integer movie;
    private Integer actor;
    private String cast;

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

    public Integer getActor() {
        return this.actor;
    }

    public void setActor(Integer actor) {
        this.actor = actor;
    }

    public String getCast() {
        return this.cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }
}

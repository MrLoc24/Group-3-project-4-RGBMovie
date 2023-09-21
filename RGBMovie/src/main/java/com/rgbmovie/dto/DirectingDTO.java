package com.rgbmovie.dto;

public class DirectingDTO {
    private Integer pk;
    private Integer movie;
    private Integer director;

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

    public Integer getDirector() {
        return this.director;
    }

    public void setDirector(Integer director) {
        this.director = director;
    }
}

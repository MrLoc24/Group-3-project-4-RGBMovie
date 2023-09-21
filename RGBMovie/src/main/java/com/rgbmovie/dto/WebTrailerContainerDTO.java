package com.rgbmovie.dto;

import lombok.Data;

@Data
public class WebTrailerContainerDTO {
    private Integer pk;
    private Integer movie;
    private String postingImg;

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

    public String getPostingImg() {
        return this.postingImg;
    }

    public void setPostingImg(String postingImg) {
        this.postingImg = postingImg;
    }
}

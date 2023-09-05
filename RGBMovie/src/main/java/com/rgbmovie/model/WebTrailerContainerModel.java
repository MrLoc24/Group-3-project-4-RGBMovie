package com.rgbmovie.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "WebTrailerContainer", schema = "rgb", catalog = "")
public class WebTrailerContainerModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "pk")
    private int pk;
    @Basic
    @Column(name = "movie")
    private Integer movie;
    @Basic
    @Column(name = "posting_img")
    private String postingImg;
    @ManyToOne
    @JoinColumn(name = "movie", referencedColumnName = "pk")
    private MovieModel movieByMovie;

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public Integer getMovie() {
        return movie;
    }

    public void setMovie(Integer movie) {
        this.movie = movie;
    }

    public String getPostingImg() {
        return postingImg;
    }

    public void setPostingImg(String postingImg) {
        this.postingImg = postingImg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WebTrailerContainerModel that = (WebTrailerContainerModel) o;
        return pk == that.pk && Objects.equals(movie, that.movie) && Objects.equals(postingImg, that.postingImg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pk, movie, postingImg);
    }

    public MovieModel getMovieByMovie() {
        return movieByMovie;
    }

    public void setMovieByMovie(MovieModel movieByMovie) {
        this.movieByMovie = movieByMovie;
    }
}

package com.rgbmovie.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Stillcut", schema = "rgb", catalog = "")
public class StillcutModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "pk")
    private int pk;
    @Basic
    @Column(name = "movie")
    private Integer movie;
    @Basic
    @Column(name = "image")
    private String image;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StillcutModel that = (StillcutModel) o;
        return pk == that.pk && Objects.equals(movie, that.movie) && Objects.equals(image, that.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pk, movie, image);
    }

    public MovieModel getMovieByMovie() {
        return movieByMovie;
    }

    public void setMovieByMovie(MovieModel movieByMovie) {
        this.movieByMovie = movieByMovie;
    }
}

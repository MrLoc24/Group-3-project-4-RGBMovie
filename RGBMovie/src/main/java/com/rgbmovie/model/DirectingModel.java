package com.rgbmovie.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Directing", schema = "rgb", catalog = "")
public class DirectingModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "pk")
    private int pk;
    @Basic
    @Column(name = "movie")
    private Integer movie;
    @Basic
    @Column(name = "director")
    private Integer director;
    @ManyToOne
    @JoinColumn(name = "movie", referencedColumnName = "pk")
    private MovieModel movieByMovie;
    @ManyToOne
    @JoinColumn(name = "director", referencedColumnName = "pk")
    private DirectorModel directorByDirector;

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

    public Integer getDirector() {
        return director;
    }

    public void setDirector(Integer director) {
        this.director = director;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DirectingModel that = (DirectingModel) o;
        return pk == that.pk && Objects.equals(movie, that.movie) && Objects.equals(director, that.director);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pk, movie, director);
    }

    public MovieModel getMovieByMovie() {
        return movieByMovie;
    }

    public void setMovieByMovie(MovieModel movieByMovie) {
        this.movieByMovie = movieByMovie;
    }

    public DirectorModel getDirectorByDirector() {
        return directorByDirector;
    }

    public void setDirectorByDirector(DirectorModel directorByDirector) {
        this.directorByDirector = directorByDirector;
    }
}

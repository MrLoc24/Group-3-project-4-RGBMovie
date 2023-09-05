package com.rgbmovie.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Casting", schema = "rgb", catalog = "")
public class CastingModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "pk")
    private int pk;
    @Basic
    @Column(name = "movie")
    private Integer movie;
    @Basic
    @Column(name = "actor")
    private Integer actor;
    @Basic
    @Column(name = "cast")
    private String cast;
    @ManyToOne
    @JoinColumn(name = "movie", referencedColumnName = "pk", insertable = false, updatable = false)
    private MovieModel movieByMovie;
    @ManyToOne
    @JoinColumn(name = "actor", referencedColumnName = "pk", insertable = false, updatable = false)
    private CastModel castByActor;

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

    public Integer getActor() {
        return actor;
    }

    public void setActor(Integer actor) {
        this.actor = actor;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CastingModel that = (CastingModel) o;
        return pk == that.pk && Objects.equals(movie, that.movie) && Objects.equals(actor, that.actor) && Objects.equals(cast, that.cast);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pk, movie, actor, cast);
    }

    public MovieModel getMovieByMovie() {
        return movieByMovie;
    }

    public void setMovieByMovie(MovieModel movieByMovie) {
        this.movieByMovie = movieByMovie;
    }

    public CastModel getCastByActor() {
        return castByActor;
    }

    public void setCastByActor(CastModel castByActor) {
        this.castByActor = castByActor;
    }
}

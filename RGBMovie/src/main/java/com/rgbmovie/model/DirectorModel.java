package com.rgbmovie.model;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Director", schema = "rgb", catalog = "")
public class DirectorModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "pk")
    private int pk;
    @Basic
    @Column(name = "director")
    private String director;
    @Basic
    @Column(name = "eng_director")
    private String engDirector;
    @Basic
    @Column(name = "profile_img")
    private String profileImg;
    @OneToMany(mappedBy = "directorByDirector")
    private Collection<DirectingModel> directingsByPk;

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getEngDirector() {
        return engDirector;
    }

    public void setEngDirector(String engDirector) {
        this.engDirector = engDirector;
    }

    public String getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(String profileImg) {
        this.profileImg = profileImg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DirectorModel that = (DirectorModel) o;
        return pk == that.pk && Objects.equals(director, that.director) && Objects.equals(engDirector, that.engDirector) && Objects.equals(profileImg, that.profileImg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pk, director, engDirector, profileImg);
    }

    public Collection<DirectingModel> getDirectingsByPk() {
        return directingsByPk;
    }

    public void setDirectingsByPk(Collection<DirectingModel> directingsByPk) {
        this.directingsByPk = directingsByPk;
    }
}

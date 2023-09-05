package com.rgbmovie.model;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Cast", schema = "rgb", catalog = "")
public class CastModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "pk")
    private int pk;
    @Basic
    @Column(name = "actor")
    private String actor;
    @Basic
    @Column(name = "eng_actor")
    private String engActor;
    @Basic
    @Column(name = "profile_img")
    private String profileImg;
    @OneToMany(mappedBy = "castByActor")
    private Collection<CastingModel> castingsByPk;

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getEngActor() {
        return engActor;
    }

    public void setEngActor(String engActor) {
        this.engActor = engActor;
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
        CastModel castModel = (CastModel) o;
        return pk == castModel.pk && Objects.equals(actor, castModel.actor) && Objects.equals(engActor, castModel.engActor) && Objects.equals(profileImg, castModel.profileImg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pk, actor, engActor, profileImg);
    }

    public Collection<CastingModel> getCastingsByPk() {
        return castingsByPk;
    }

    public void setCastingsByPk(Collection<CastingModel> castingsByPk) {
        this.castingsByPk = castingsByPk;
    }
}

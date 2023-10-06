package com.rgbmovie.dto;

import lombok.Data;

@Data
public class CastDTO {
    private Integer pk;
    private String actor;
    private String engActor;
    private String profileImg;

    public Integer getPk() {
        return this.pk;
    }

    public void setPk(Integer pk) {
        this.pk = pk;
    }

    public String getActor() {
        return this.actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getEngActor() {
        return this.engActor;
    }

    public void setEngActor(String engActor) {
        this.engActor = engActor;
    }

    public String getProfileImg() {
        return this.profileImg;
    }

    public void setProfileImg(String profileImg) {
        this.profileImg = profileImg;
    }
}

package com.rgbmovie.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "MainContainer", schema = "rgb", catalog = "")
public class MainContainerModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "pk")
    private int pk;
    @Basic
    @Column(name = "event_name")
    private String eventName;
    @Basic
    @Column(name = "posting_start")
    private Timestamp postingStart;
    @Basic
    @Column(name = "posting_end")
    private Timestamp postingEnd;
    @Basic
    @Column(name = "container_img")
    private String containerImg;
    @Basic
    @Column(name = "container_link")
    private String containerLink;
    @Basic
    @Column(name = "is_active")
    private Boolean isActive;

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Timestamp getPostingStart() {
        return postingStart;
    }

    public void setPostingStart(Timestamp postingStart) {
        this.postingStart = postingStart;
    }

    public Timestamp getPostingEnd() {
        return postingEnd;
    }

    public void setPostingEnd(Timestamp postingEnd) {
        this.postingEnd = postingEnd;
    }

    public String getContainerImg() {
        return containerImg;
    }

    public void setContainerImg(String containerImg) {
        this.containerImg = containerImg;
    }

    public String getContainerLink() {
        return containerLink;
    }

    public void setContainerLink(String containerLink) {
        this.containerLink = containerLink;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MainContainerModel that = (MainContainerModel) o;
        return pk == that.pk && Objects.equals(eventName, that.eventName) && Objects.equals(postingStart, that.postingStart) && Objects.equals(postingEnd, that.postingEnd) && Objects.equals(containerImg, that.containerImg) && Objects.equals(containerLink, that.containerLink) && Objects.equals(isActive, that.isActive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pk, eventName, postingStart, postingEnd, containerImg, containerLink, isActive);
    }
}

package com.rgbmovie.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "EventContainer", schema = "rgb", catalog = "")
public class EventContainerModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "pk")
    private int pk;
    @Basic
    @Column(name = "event_name")
    private String eventName;
    @Basic
    @Column(name = "container_img")
    private String containerImg;
    @Basic
    @Column(name = "container_link")
    private String containerLink;
    @Basic
    @Column(name = "is_active")
    private Integer isActive;

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

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventContainerModel that = (EventContainerModel) o;
        return pk == that.pk && Objects.equals(eventName, that.eventName) && Objects.equals(containerImg, that.containerImg) && Objects.equals(containerLink, that.containerLink) && Objects.equals(isActive, that.isActive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pk, eventName, containerImg, containerLink, isActive);
    }
}

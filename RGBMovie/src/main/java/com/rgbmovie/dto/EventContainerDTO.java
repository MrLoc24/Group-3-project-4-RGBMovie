package com.rgbmovie.dto;

import lombok.Data;

@Data
public class EventContainerDTO {
    private Integer pk;
    private String eventName;
    private String containerImg;
    private String containerLink;
    private Integer isActive;

    public Integer getPk() {
        return this.pk;
    }

    public void setPk(Integer pk) {
        this.pk = pk;
    }

    public String getEventName() {
        return this.eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getContainerImg() {
        return this.containerImg;
    }

    public void setContainerImg(String containerImg) {
        this.containerImg = containerImg;
    }

    public String getContainerLink() {
        return this.containerLink;
    }

    public void setContainerLink(String containerLink) {
        this.containerLink = containerLink;
    }

    public Integer getIsActive() {
        return this.isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }
}

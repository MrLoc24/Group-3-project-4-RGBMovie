package com.rgbmovie.dto;

public class ReservationDTO {
    private Integer pk;
    private Integer user;
    private Integer screening;
    private Integer isActive;
    private Integer getPaid;
    private Float totalCost;

    public Integer getPk() {
        return this.pk;
    }

    public void setPk(Integer pk) {
        this.pk = pk;
    }

    public Integer getUser() {
        return this.user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public Integer getScreening() {
        return this.screening;
    }

    public void setScreening(Integer screening) {
        this.screening = screening;
    }

    public Integer getIsActive() {
        return this.isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public Integer getGetPaid() {
        return this.getPaid;
    }

    public void setGetPaid(Integer getPaid) {
        this.getPaid = getPaid;
    }

    public Float getTotalCost() {
        return this.totalCost;
    }

    public void setTotalCost(Float totalCost) {
        this.totalCost = totalCost;
    }
}

package com.rgbmovie.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Data
@Setter
public class TheaterDTO {
    private Integer pk;
    private String location;
    private String subLocation;
    private String address;

    public void setPk(Integer pk) {
        this.pk = pk;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setSubLocation(String subLocation) {
        this.subLocation = subLocation;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

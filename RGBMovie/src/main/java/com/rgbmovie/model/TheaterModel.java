package com.rgbmovie.model;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Theater", schema = "rgb", catalog = "")
public class TheaterModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "pk")
    private int pk;
    @Basic
    @Column(name = "location")
    private String location;
    @Basic
    @Column(name = "sub_location")
    private String subLocation;
    @Basic
    @Column(name = "address")
    private String address;
    @OneToMany(mappedBy = "theaterByTheater")
    private Collection<AuditoriumModel> auditoriumsByPk;
    @OneToMany(mappedBy = "theaterByTheater")
    private Collection<ScreeningModel> screeningsByPk;
    @OneToMany(mappedBy = "theaterByTheaterId")
    private Collection<WorkplaceModel> workplacesByPk;

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSubLocation() {
        return subLocation;
    }

    public void setSubLocation(String subLocation) {
        this.subLocation = subLocation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TheaterModel that = (TheaterModel) o;
        return pk == that.pk && Objects.equals(location, that.location) && Objects.equals(subLocation, that.subLocation) && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pk, location, subLocation, address);
    }

    public Collection<AuditoriumModel> getAuditoriumsByPk() {
        return auditoriumsByPk;
    }

    public void setAuditoriumsByPk(Collection<AuditoriumModel> auditoriumsByPk) {
        this.auditoriumsByPk = auditoriumsByPk;
    }

    public Collection<ScreeningModel> getScreeningsByPk() {
        return screeningsByPk;
    }

    public void setScreeningsByPk(Collection<ScreeningModel> screeningsByPk) {
        this.screeningsByPk = screeningsByPk;
    }

    public Collection<WorkplaceModel> getWorkplacesByPk() {
        return workplacesByPk;
    }

    public void setWorkplacesByPk(Collection<WorkplaceModel> workplacesByPk) {
        this.workplacesByPk = workplacesByPk;
    }
}

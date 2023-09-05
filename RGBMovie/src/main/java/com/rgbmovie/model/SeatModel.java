package com.rgbmovie.model;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Seat", schema = "rgb", catalog = "")
public class SeatModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "pk")
    private int pk;
    @Basic
    @Column(name = "row")
    private Integer row;
    @Basic
    @Column(name = "number")
    private Integer number;
    @Basic
    @Column(name = "auditorium")
    private Integer auditorium;
    @Basic
    @Column(name = "seat_name")
    private String seatName;
    @OneToMany(mappedBy = "seatBySeat")
    private Collection<ReservedSeatModel> reservedSeatsByPk;
    @ManyToOne
    @JoinColumn(name = "auditorium", referencedColumnName = "pk")
    private AuditoriumModel auditoriumByAuditorium;

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(Integer auditorium) {
        this.auditorium = auditorium;
    }

    public String getSeatName() {
        return seatName;
    }

    public void setSeatName(String seatName) {
        this.seatName = seatName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SeatModel seatModel = (SeatModel) o;
        return pk == seatModel.pk && Objects.equals(row, seatModel.row) && Objects.equals(number, seatModel.number) && Objects.equals(auditorium, seatModel.auditorium) && Objects.equals(seatName, seatModel.seatName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pk, row, number, auditorium, seatName);
    }

    public Collection<ReservedSeatModel> getReservedSeatsByPk() {
        return reservedSeatsByPk;
    }

    public void setReservedSeatsByPk(Collection<ReservedSeatModel> reservedSeatsByPk) {
        this.reservedSeatsByPk = reservedSeatsByPk;
    }

    public AuditoriumModel getAuditoriumByAuditorium() {
        return auditoriumByAuditorium;
    }

    public void setAuditoriumByAuditorium(AuditoriumModel auditoriumByAuditorium) {
        this.auditoriumByAuditorium = auditoriumByAuditorium;
    }
}

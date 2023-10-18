package com.rgbmovie.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Movie", schema = "rgb", catalog = "")
public class MovieModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "pk")
    private int pk;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "eng_title")
    private String engTitle;
    @Basic
    @Column(name = "duration_min")
    private Integer durationMin;
    @Basic
    @Column(name = "age")
    private String age;
    @Basic
    @Column(name = "opening_date")
    private Date openingDate;
    @Basic
    @Column(name = "genre")
    private String genre;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "trailer")
    private String trailer;
    @Basic
    @Column(name = "reservation_score")
    private Double reservationScore;
    @Basic
    @Column(name = "main_img")
    private String mainImg;
    @Basic
    @Column(name = "thumbnail_img")
    private String thumbnailImg;
    @Basic
    @Column(name = "price")
    private Double price;
    @OneToMany(mappedBy = "movieByMovie")
    private Collection<CastingModel> castingsByPk;
    @OneToMany(mappedBy = "movieByMovie")
    private Collection<DirectingModel> directingsByPk;
    @OneToMany(mappedBy = "movieByMovie")
    private Collection<ScreeningModel> screeningsByPk;
    @OneToMany(mappedBy = "movieByMovie")
    private Collection<StillcutModel> stillcutsByPk;

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEngTitle() {
        return engTitle;
    }

    public void setEngTitle(String engTitle) {
        this.engTitle = engTitle;
    }

    public Integer getDurationMin() {
        return durationMin;
    }

    public void setDurationMin(Integer durationMin) {
        this.durationMin = durationMin;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Date getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(Date openingDate) {
        this.openingDate = openingDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public Double getReservationScore() {
        return reservationScore;
    }

    public void setReservationScore(Double reservationScore) {
        this.reservationScore = reservationScore;
    }

    public String getMainImg() {
        return mainImg;
    }

    public void setMainImg(String mainImg) {
        this.mainImg = mainImg;
    }

    public String getThumbnailImg() {
        return thumbnailImg;
    }

    public void setThumbnailImg(String thumbnailImg) {
        this.thumbnailImg = thumbnailImg;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieModel that = (MovieModel) o;
        return pk == that.pk && Objects.equals(title, that.title) && Objects.equals(engTitle, that.engTitle) && Objects.equals(durationMin, that.durationMin) && Objects.equals(age, that.age) && Objects.equals(openingDate, that.openingDate) && Objects.equals(genre, that.genre) && Objects.equals(description, that.description) && Objects.equals(trailer, that.trailer) && Objects.equals(reservationScore, that.reservationScore) && Objects.equals(mainImg, that.mainImg) && Objects.equals(thumbnailImg, that.thumbnailImg) && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pk, title, engTitle, durationMin, age, openingDate, genre, description, trailer, reservationScore, mainImg, thumbnailImg, price);
    }

    public Collection<CastingModel> getCastingsByPk() {
        return castingsByPk;
    }

    public void setCastingsByPk(Collection<CastingModel> castingsByPk) {
        this.castingsByPk = castingsByPk;
    }

    public Collection<DirectingModel> getDirectingsByPk() {
        return directingsByPk;
    }

    public void setDirectingsByPk(Collection<DirectingModel> directingsByPk) {
        this.directingsByPk = directingsByPk;
    }

    public Collection<ScreeningModel> getScreeningsByPk() {
        return screeningsByPk;
    }

    public void setScreeningsByPk(Collection<ScreeningModel> screeningsByPk) {
        this.screeningsByPk = screeningsByPk;
    }

    public Collection<StillcutModel> getStillcutsByPk() {
        return stillcutsByPk;
    }

    public void setStillcutsByPk(Collection<StillcutModel> stillcutsByPk) {
        this.stillcutsByPk = stillcutsByPk;
    }


}

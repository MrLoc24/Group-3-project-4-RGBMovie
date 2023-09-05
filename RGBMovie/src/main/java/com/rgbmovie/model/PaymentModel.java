package com.rgbmovie.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Payment", schema = "rgb", catalog = "")
public class PaymentModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "pk")
    private int pk;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "card_number")
    private Integer cardNumber;
    @Basic
    @Column(name = "date_expried")
    private String dateExpried;
    @Basic
    @Column(name = "cvv")
    private String cvv;
    @Basic
    @Column(name = "user_id")
    private Integer userId;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "pk")
    private UserModel userByUserId;

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Integer cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getDateExpried() {
        return dateExpried;
    }

    public void setDateExpried(String dateExpried) {
        this.dateExpried = dateExpried;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentModel that = (PaymentModel) o;
        return pk == that.pk && Objects.equals(name, that.name) && Objects.equals(cardNumber, that.cardNumber) && Objects.equals(dateExpried, that.dateExpried) && Objects.equals(cvv, that.cvv) && Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pk, name, cardNumber, dateExpried, cvv, userId);
    }

    public UserModel getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserModel userByUserId) {
        this.userByUserId = userByUserId;
    }
}

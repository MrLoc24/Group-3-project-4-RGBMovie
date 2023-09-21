package com.rgbmovie.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@Table(name = "User", schema = "rgb", catalog = "")
public class UserModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "pk")
    private int pk;
    @Basic
    @Column(name = "username")
    private String username;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "last_name")
    private String lastName;
    @Basic
    @Column(name = "first_name")
    private String firstName;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "phone_number")
    private String phoneNumber;
    @Basic
    @Column(name = "images")
    private String images;
    @Basic
    @Column(name = "enabled")
    private boolean enabled;
    @OneToMany(mappedBy = "userByUserId")
    private Collection<BankingModel> bankingsByPk;
    @OneToMany(mappedBy = "userByUserId")
    private Collection<PaymentModel> paymentsByPk;
    @OneToMany(mappedBy = "userByUser")
    private Collection<ReservationModel> reservationsByPk;
    @ManyToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name="UserRole",
            joinColumns = {@JoinColumn(name="user_id")},
            inverseJoinColumns = {@JoinColumn(name="role_id")}
    )
    private Set<RoleModel> roles = new HashSet<>();

    public Set<RoleModel> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleModel> roles) {
        this.roles = roles;
    }
    public void addRole(RoleModel role) {
        this.roles.add(role);
    }

    @OneToMany(mappedBy = "userByUserId")
    private Collection<WorkplaceModel> workplacesByPk;

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserModel userModel = (UserModel) o;
        return pk == userModel.pk && enabled == userModel.enabled && Objects.equals(username, userModel.username) && Objects.equals(password, userModel.password) && Objects.equals(lastName, userModel.lastName) && Objects.equals(firstName, userModel.firstName) && Objects.equals(email, userModel.email) && Objects.equals(phoneNumber, userModel.phoneNumber) && Objects.equals(images, userModel.images);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pk, username, password, lastName, firstName, email, phoneNumber, images, enabled);
    }

    public Collection<BankingModel> getBankingsByPk() {
        return bankingsByPk;
    }

    public void setBankingsByPk(Collection<BankingModel> bankingsByPk) {
        this.bankingsByPk = bankingsByPk;
    }

    public Collection<PaymentModel> getPaymentsByPk() {
        return paymentsByPk;
    }

    public void setPaymentsByPk(Collection<PaymentModel> paymentsByPk) {
        this.paymentsByPk = paymentsByPk;
    }

    public Collection<ReservationModel> getReservationsByPk() {
        return reservationsByPk;
    }

    public void setReservationsByPk(Collection<ReservationModel> reservationsByPk) {
        this.reservationsByPk = reservationsByPk;
    }


    public Collection<WorkplaceModel> getWorkplacesByPk() {
        return workplacesByPk;
    }

    public void setWorkplacesByPk(Collection<WorkplaceModel> workplacesByPk) {
        this.workplacesByPk = workplacesByPk;
    }
}

package com.rgbmovie.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "UserRole", schema = "rgb", catalog = "")
public class UserRoleModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "pk")
    private int pk;
    @Basic
    @Column(name = "user_id")
    private int userId;
    @Basic
    @Column(name = "role_id")
    private int roleId;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "pk", nullable = false)
    private UserModel userByUserId;
    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "pk", nullable = false)
    private RoleModel roleByRoleId;

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRoleModel that = (UserRoleModel) o;
        return pk == that.pk && userId == that.userId && roleId == that.roleId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pk, userId, roleId);
    }

    public UserModel getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserModel userByUserId) {
        this.userByUserId = userByUserId;
    }

    public RoleModel getRoleByRoleId() {
        return roleByRoleId;
    }

    public void setRoleByRoleId(RoleModel roleByRoleId) {
        this.roleByRoleId = roleByRoleId;
    }
}

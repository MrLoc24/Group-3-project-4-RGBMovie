package com.rgbmovie.model;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Role", schema = "rgb", catalog = "")
public class RoleModel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "pk")
    private int pk;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "roleByRoleId")
    private Collection<UserRoleModel> userRolesByPk;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleModel roleModel = (RoleModel) o;
        return pk == roleModel.pk && Objects.equals(name, roleModel.name) && Objects.equals(description, roleModel.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pk, name, description);
    }

    public Collection<UserRoleModel> getUserRolesByPk() {
        return userRolesByPk;
    }

    public void setUserRolesByPk(Collection<UserRoleModel> userRolesByPk) {
        this.userRolesByPk = userRolesByPk;
    }
}

package com.rgbmovie.repository;

import com.rgbmovie.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {
	@Query("SELECT e FROM UserModel e WHERE e.username LIKE :username OR e.email LIKE :username ")
    UserModel findUserModelByUsernameOrEmail(@Param("username") String name);

    @Query("SELECT u FROM UserModel u JOIN UserRoleModel ur ON u.pk = ur.userId JOIN RoleModel r ON ur.roleId = r.pk WHERE r.name NOT LIKE 'ROLE_CUSTOMER'")
    List<UserModel> findStaff();

    @Query("SELECT u FROM UserModel u JOIN UserRoleModel ur ON u.pk = ur.userId JOIN RoleModel r ON ur.roleId = r.pk WHERE r.name  LIKE 'ROLE_CUSTOMER'")
    List<UserModel> findCustomer();

    @Transactional
    @Modifying
    @Query("UPDATE UserModel u SET u.username = :username, u.lastName = :lastName, u.firstName = :firstName, u.email = :email, u.phoneNumber = :phoneNumber, u.images = :images WHERE u.pk = :pk")
    int updateUser(@Param("pk") Integer pk, @Param("username") String username, @Param("lastName") String lastName, @Param("firstName") String firstName, @Param("email") String email, @Param("phoneNumber") String phoneNumber, @Param("images") String images);

    //Deactivate account
    @Transactional
    @Modifying
    @Query("UPDATE UserModel u SET u.enabled = :enabled WHERE u.pk = :pk")
    int setStatus(@Param("pk") Integer pk, @Param("enabled") boolean enabled);

}

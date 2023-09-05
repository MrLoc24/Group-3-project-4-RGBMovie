package com.rgbmovie.repository;

import com.rgbmovie.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {
	@Query("SELECT e FROM UserModel e WHERE e.username LIKE :username OR e.email LIKE :username ")
    UserModel findUserModelByUsernameOrEmail(@Param("username") String name);
}

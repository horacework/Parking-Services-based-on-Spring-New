package com.horacework.repository;

import com.horacework.model.UsercarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsercarRepository extends JpaRepository<UsercarEntity,String>{

    @Query(value = "SELECT p FROM UsercarEntity p" +
            " where p.userId=:userId and p.isDel=0 ")
    List<UsercarEntity> findUserCarById(@Param("userId") String userId);

    @Query(value = "SELECT p FROM UsercarEntity p" +
            " where p.carId=:carId and p.isDel=0 ")
    UsercarEntity findUserCarNameById(@Param("carId") String carId);

    @Query(value = "SELECT p FROM UsercarEntity p" +
            " where p.userId=:userId and p.carId=:carId and p.isDel=0 ")
    UsercarEntity findOneUserCarById(@Param("userId") String userId , @Param("carId") String carId);
}

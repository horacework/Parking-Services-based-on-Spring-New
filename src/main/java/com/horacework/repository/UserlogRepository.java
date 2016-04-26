package com.horacework.repository;

import com.horacework.model.UserlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface UserlogRepository extends JpaRepository<UserlogEntity,String>{

    @Query(value = "SELECT p FROM UserlogEntity p" +
            " where p.loginTime=(SELECT max(q.loginTime)from UserlogEntity q where q.userId=:userId) and p.userId=:userId and p.deviceId=:deviceId ")
    UserlogEntity findUserLogout(@Param("userId") String userId ,@Param("deviceId") String deviceId );
}

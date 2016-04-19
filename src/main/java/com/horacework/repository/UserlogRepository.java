package com.horacework.repository;

import com.horacework.model.UserlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface UserlogRepository extends JpaRepository<UserlogEntity,String>{

    @Query(value = "update UserlogEntity p " +
            "SET p.logoutTime =:LogoutTime," +
            "p.isLoginOut=1" +
            " where p.loginTime=(SELECT max(loginTime)from UserlogEntity where userId=:userId) and p.userId=:userId")
    UserlogEntity updateUserLogout(@Param("userId") String userId , @Param("LogoutTime") Timestamp LogoutTime );
}

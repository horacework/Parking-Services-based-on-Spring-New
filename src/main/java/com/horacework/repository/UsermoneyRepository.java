package com.horacework.repository;

import com.horacework.model.UsermoneyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsermoneyRepository extends JpaRepository<UsermoneyEntity,String>{

    @Query(value = "select p from UsermoneyEntity p where p.userId=:userId and p.currentTime=(SELECT max(q.currentTime)FROM UsermoneyEntity q WHERE q.userId=:userId) ")
    UsermoneyEntity findUserMoneyLastLogById(@Param("userId") String userId);

    @Query(value = "select p from UsermoneyEntity p where p.userId=:userId  ORDER BY p.currentTime DESC")
    List<UsermoneyEntity> findUserMoneyAllLogById(@Param("userId") String userId);
}

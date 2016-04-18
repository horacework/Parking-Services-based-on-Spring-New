package com.horacework.repository;

import com.horacework.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,String>{

    @Query(value = "select p from UserEntity p where p.name=:name")
    UserEntity findUserSerect(@Param("name") String name);
}

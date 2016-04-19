package com.horacework.repository;

import com.horacework.model.UserlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserlogRepository extends JpaRepository<UserlogEntity,String>{

//    @Query(value = "select p from UserEntity p where p.name=:name")
//    UserEntity findUserSerect(@Param("name") String name);
}

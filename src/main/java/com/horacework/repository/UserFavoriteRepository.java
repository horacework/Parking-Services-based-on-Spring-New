package com.horacework.repository;

import com.horacework.model.UserfavoriteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserFavoriteRepository extends JpaRepository<UserfavoriteEntity,String>{

    @Query(value = "SELECT p FROM UserfavoriteEntity p" +
            " where p.userId=:userId and p.isCancel=0 ")
    List<UserfavoriteEntity> findUserFavoriteByUserId(@Param("userId") String userId);

    @Query(value = "SELECT p FROM UserfavoriteEntity p" +
            " where p.id=:id and p.userId=:userId ")
    UserfavoriteEntity UserFavoriteDelete(@Param("id") String id,@Param("userId") String userId);

    @Query(value = "SELECT p FROM UserfavoriteEntity p" +
            " where p.userId=:userId and p.markerId=:markerId and p.isCancel=0 ")
    List<UserfavoriteEntity> UserFavoriteCheck(@Param("userId") String userId,@Param("markerId") String markerId);
}

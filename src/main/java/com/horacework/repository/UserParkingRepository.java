package com.horacework.repository;

import com.horacework.model.ParkinglogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserParkingRepository extends JpaRepository<ParkinglogEntity,String>{

    @Query(value = "select p from ParkinglogEntity p where p.userId=:userId and p.leaveTime!=null ORDER BY p.enterTime DESC")
    List<ParkinglogEntity> findUserParkingAllLogById(@Param("userId") String userId);

    @Query(value = "select p from ParkinglogEntity p where p.userId=:userId and p.leaveTime=null ORDER BY p.enterTime DESC")
    List<ParkinglogEntity> userParkingStatusById(@Param("userId") String userId);

}

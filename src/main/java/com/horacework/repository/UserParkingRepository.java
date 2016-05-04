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

    @Query(value = "select p from ParkinglogEntity p where p.userId=:userId and p.leaveTime=null and p.markerId=:markerId and p.carId=:carId")
    List<ParkinglogEntity> checkUserCarIsInTheMarker(@Param("userId") String userId , @Param("markerId") String markerId , @Param("carId") String carId);

    @Query(value = "select p from ParkinglogEntity p where p.leaveTime=null and p.markerId=:markerId")
    List<ParkinglogEntity> checkTheMarkerParkingNum(@Param("markerId") String markerId);

    @Query(value = "select p from ParkinglogEntity p where p.isComplete=0 and p.markerId=:markerId and p.carId=:carId")
    List<ParkinglogEntity> checkCarParkingLog(@Param("markerId") String markerId , @Param("carId") String carId);
}

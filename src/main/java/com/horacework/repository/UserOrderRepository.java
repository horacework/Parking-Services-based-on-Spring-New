package com.horacework.repository;

import com.horacework.model.UserorderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface UserOrderRepository extends JpaRepository<UserorderEntity,String>{

    @Query(value = "select p from UserorderEntity p where p.orderTime>:currentTime and p.userId=:userId and p.isDel=0 order by p.orderTime")
    List<UserorderEntity> findUserOrderByUserId(@Param("userId") String userId ,@Param("currentTime") Timestamp currentTime);

    @Query(value = "select p from UserorderEntity p where p.orderId=:orderId and p.userId=:userId and p.isDel=0 ")
    UserorderEntity findUserOrderByOrderIdAndUserId(@Param("orderId") String orderId,@Param("userId") String userId );

    @Query(value = "select p from UserorderEntity p where p.userId=:userId and p.orderTime=:orderTime and p.markerId=:markerId")
    List<UserorderEntity> checkUserOrderIsRepeat(@Param("userId") String userId , @Param("orderTime") Timestamp orderTime , @Param("markerId") String markerId);

    @Query(value = "select p from UserorderEntity p where p.userId=:userId and p.markerId=:markerId and orderTime>:currentTime and orderTime<:currentTimeAfterTwoHour")
    List<UserorderEntity> checkUserIsOrderOntime(@Param("userId") String userId , @Param("markerId") String markerId , @Param("currentTime") Timestamp currentTime , @Param("currentTimeAfterTwoHour") Timestamp currentTimeAfterTwoHour);

    @Query(value = "select p from UserorderEntity p where p.markerId=:markerId and orderTime>:currentTime and orderTime<:currentTimeAfterTwoHour")
    List<UserorderEntity> checkMarkerOrderOntime(@Param("markerId") String markerId , @Param("currentTime") Timestamp currentTime , @Param("currentTimeAfterTwoHour") Timestamp currentTimeAfterTwoHour);

}

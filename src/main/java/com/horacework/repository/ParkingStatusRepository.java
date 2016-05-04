package com.horacework.repository;

import com.horacework.model.ParkingstatusEntity;
import com.horacework.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingStatusRepository extends JpaRepository<ParkingstatusEntity,String>{

}

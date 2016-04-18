package com.horacework.repository;

import com.horacework.model.MarkeridEntity;
import com.horacework.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by HoraceChan on 2016/4/18.
 */
@Repository
public interface MarkeridRepository extends JpaRepository<MarkeridEntity,String>{

}

package com.horacework.repository;

import com.horacework.model.MarkerinfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by HoraceChan on 2016/4/18.
 */
@Repository
public interface MarkerinfoRepository extends JpaRepository<MarkerinfoEntity,String>{


}

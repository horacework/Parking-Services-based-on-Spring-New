package com.horacework.repository;

import com.horacework.model.FeedbackEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserFeedbackRepository extends JpaRepository<FeedbackEntity,String>{

}

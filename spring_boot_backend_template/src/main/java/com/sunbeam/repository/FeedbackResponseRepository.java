package com.sunbeam.Repository;


import com.sunbeam.entities.FeedbackResponseEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackResponseRepository extends JpaRepository<FeedbackResponseEntity, Long> {
}
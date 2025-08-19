package com.sunbeam.repository;


import com.sunbeam.entities.FeedbackResponse;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackResponseRepository extends JpaRepository<FeedbackResponse, Long> {
}
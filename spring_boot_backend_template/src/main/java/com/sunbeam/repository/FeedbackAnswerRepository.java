package com.sunbeam.repository;

import com.sunbeam.entities.FeedbackAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackAnswerRepository extends JpaRepository<FeedbackAnswer, Long> {
}

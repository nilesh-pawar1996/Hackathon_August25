package com.sunbeam.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.FeedbackTemplateEntity;

public interface FeedbackTemplateRepository extends JpaRepository<FeedbackTemplateEntity, Long> {
}

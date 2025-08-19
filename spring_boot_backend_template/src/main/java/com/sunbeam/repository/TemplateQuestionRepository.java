package com.sunbeam.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.TemplateQuestion;

public interface TemplateQuestionRepository extends JpaRepository<TemplateQuestion, Long> {
}

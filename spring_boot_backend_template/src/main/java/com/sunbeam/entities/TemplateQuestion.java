package com.sunbeam.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "template_questions")
public class TemplateQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;

    @ManyToOne
    @JoinColumn(name = "template_id", nullable = false)
    private FeedbackTemplate template;

    @Column(nullable = false, length = 500)
    private String questionText;

    private Integer orderNo;

    // Getters & Setters
    public Long getQuestionId() { return questionId; }
    public void setQuestionId(Long questionId) { this.questionId = questionId; }

    public FeedbackTemplate getTemplate() { return template; }
    public void setTemplate(FeedbackTemplate template) { this.template = template; }

    public String getQuestionText() { return questionText; }
    public void setQuestionText(String questionText) { this.questionText = questionText; }

    public Integer getOrderNo() { return orderNo; }
    public void setOrderNo(Integer orderNo) { this.orderNo = orderNo; }
}

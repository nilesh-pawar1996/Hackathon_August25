package com.sunbeam.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "feedback_answers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FeedbackAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)   // each answer belongs to one question
    @JoinColumn(name = "question_id", nullable = false)
    private TemplateQuestion question;

    @Column(nullable = false)
    private String answerText;

    @ManyToOne(fetch = FetchType.LAZY)   // each answer belongs to one response
    @JoinColumn(name = "response_id", nullable = false)
    private FeedbackResponse response;
}

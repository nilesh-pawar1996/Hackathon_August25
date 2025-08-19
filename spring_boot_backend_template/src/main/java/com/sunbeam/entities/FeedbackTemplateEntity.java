package com.sunbeam.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "feedback_templates")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true, exclude = {"createdBy", "questions"})
public class FeedbackTemplateEntity extends BaseEntity {

    @Column(length = 100, nullable = false, unique = true)
    private String templateName;

    // Template created by Admin
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by", nullable = false)
    private User createdBy;

    // Template has many questions
    @OneToMany(mappedBy = "template", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TemplateQuestionEntity> questions;
}

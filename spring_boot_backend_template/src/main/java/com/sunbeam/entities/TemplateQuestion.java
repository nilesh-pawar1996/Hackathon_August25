package com.sunbeam.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "template_questions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true, exclude = "template")
public class TemplateQuestion extends BaseEntity {

    @Column(nullable = false, length = 300)
    private String questionText;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "template_id", nullable = false)
    private FeedbackTemplateEntity template;
}

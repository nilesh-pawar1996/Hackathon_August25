package com.sunbeam.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FeedbackAnswerDto {
    private Long id;
    private Long questionId;
    private String answerText;
}

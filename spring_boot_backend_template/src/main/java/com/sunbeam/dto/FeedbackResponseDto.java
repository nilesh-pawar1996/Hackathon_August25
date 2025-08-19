package com.sunbeam.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FeedbackResponseDto {
    private Long id;
    private Long studentId;
    private Long templateId;
    private List<FeedbackAnswerDto> answers;
}
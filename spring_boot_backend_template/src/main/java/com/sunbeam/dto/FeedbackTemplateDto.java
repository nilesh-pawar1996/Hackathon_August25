package com.sunbeam.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FeedbackTemplateDto {
    private Long id;
    private String title;
    private String description;
    private List<TemplateQuestionDto> questions;
}
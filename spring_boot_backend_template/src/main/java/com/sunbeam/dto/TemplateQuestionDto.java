package com.sunbeam.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TemplateQuestionDto {
    private Long id;
    private String questionText;
}
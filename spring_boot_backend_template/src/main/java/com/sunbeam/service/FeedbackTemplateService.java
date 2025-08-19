package com.sunbeam.service;

import com.sunbeam.dto.FeedbackTemplateDto;
import java.util.List;

public interface FeedbackTemplateService {
    List<FeedbackTemplateDto> getAllTemplates();
    FeedbackTemplateDto getTemplateById(Long id);
    FeedbackTemplateDto createTemplate(FeedbackTemplateDto dto);
    void deleteTemplate(Long id);
}
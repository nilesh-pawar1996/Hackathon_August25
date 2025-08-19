package com.sunbeam.service;

import com.sunbeam.Repository.FeedbackTemplateRepository;
import com.sunbeam.dto.FeedbackTemplateDto;
import com.sunbeam.dto.TemplateQuestionDto;
import com.sunbeam.entities.FeedbackTemplate;
import com.sunbeam.entities.TemplateQuestion;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FeedbackTemplateServiceImpl implements FeedbackTemplateService {

    private final FeedbackTemplateRepository templateRepo;

    @Override
    public List<FeedbackTemplateDto> getAllTemplates() {
        return templateRepo.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public FeedbackTemplateDto getTemplateById(Long id) {
        return templateRepo.findById(id)
                .map(this::mapToDto)
                .orElseThrow(() -> new RuntimeException("Template not found with id: " + id));
    }

    @Override
    public FeedbackTemplateDto createTemplate(FeedbackTemplateDto dto) {
        FeedbackTemplate template = new FeedbackTemplate();
        template.setTitle(dto.getTitle());
        template.setDescription(dto.getDescription());

        List<TemplateQuestion> questions = dto.getQuestions().stream()
                .map(q -> {
                    TemplateQuestion question = new TemplateQuestion();
                    question.setQuestionText(q.getQuestionText());
                    question.setTemplate(template); // link back
                    return question;
                })
                .collect(Collectors.toList());

        template.setQuestions(questions);

        FeedbackTemplate saved = templateRepo.save(template);
        return mapToDto(saved);
    }

    @Override
    public void deleteTemplate(Long id) {
        if (!templateRepo.existsById(id)) {
            throw new RuntimeException("Template not found with id: " + id);
        }
        templateRepo.deleteById(id);
    }

    // mapper
    private FeedbackTemplateDto mapToDto(FeedbackTemplate template) {
        return FeedbackTemplateDto.builder()
                .id(template.getId())
                .title(template.getTitle())
                .description(template.getDescription())
                .questions(template.getQuestions().stream()
                        .map(q -> new TemplateQuestionDto(q.getId(), q.getQuestionText()))
                        .collect(Collectors.toList()))
                .build();
    }
}
package com.sunbeam.service;

import com.sunbeam.dto.FeedbackAnswerDto;
import com.sunbeam.dto.FeedbackResponseDto;
import com.sunbeam.entities.*;
import com.sunbeam.repository.FeedbackResponseRepository;
import com.sunbeam.repository.TemplateQuestionRepository;
import com.sunbeam.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FeedbackResponseServiceImpl implements FeedbackResponseService {

    private final FeedbackResponseRepository responseRepo;
    private final UserRepository userRepo;
    private final FeedbackResponseRepository templateRepo;
    private final TemplateQuestionRepository questionRepo;

    @Override
    public List<FeedbackResponseDto> getAllResponses() {
        return responseRepo.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public FeedbackResponseDto getResponseById(Long id) {
        return responseRepo.findById(id)
                .map(this::mapToDto)
                .orElseThrow(() -> new RuntimeException("Response not found with id: " + id));
    }

    @Override
    public FeedbackResponseDto submitResponse(FeedbackResponseDto dto) {
        User student = userRepo.findById(dto.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        FeedbackResponse template = templateRepo.findById(dto.getTemplateId())
                .orElseThrow(() -> new RuntimeException("Template not found"));

        FeedbackResponse response = new FeedbackResponse();
        response.setStudent(student);
        response.setTemplate(template);

        List<FeedbackAnswer> answers = dto.getAnswers().stream()
                .map(a -> {
                    TemplateQuestion question = questionRepo.findById(a.getQuestionId())
                            .orElseThrow(() -> new RuntimeException("Question not found: " + a.getQuestionId()));
                    return FeedbackAnswer.builder()
                            .question(question)
                            .answerText(a.getAnswerText())
                            .response(response)
                            .build();
                })
                .collect(Collectors.toList());

        response.setAnswers(answers);

        FeedbackResponse saved = responseRepo.save(response);
        return mapToDto(saved);
    }

    @Override
    public void deleteResponse(Long id) {
        if (!responseRepo.existsById(id)) {
            throw new RuntimeException("Response not found with id: " + id);
        }
        responseRepo.deleteById(id);
    }

    // Mapper
    private FeedbackResponseDto mapToDto(FeedbackResponse response) {
        return FeedbackResponseDto.builder()
                .id(response.getId())
                .studentId(response.getStudent().getId())
                .templateId(response.getTemplate().getId())
                .answers(response.getAnswers().stream()
                        .map(a -> new FeedbackAnswerDto(
                                a.getId(),
                                a.getQuestion().getId(),
                                a.getAnswerText()
                        ))
                        .collect(Collectors.toList()))
                .build();
    }
}
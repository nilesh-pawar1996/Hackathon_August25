package com.sunbeam.service;


import com.sunbeam.dto.FeedbackAnswerDto;
import com.sunbeam.entities.FeedbackAnswer;
import com.sunbeam.entities.FeedbackResponse;
import com.sunbeam.entities.TemplateQuestion;
import com.sunbeam.repository.FeedbackAnswerRepository;
import com.sunbeam.repository.FeedbackResponseRepository;
import com.sunbeam.repository.TemplateQuestionRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FeedbackAnswerServiceImpl implements FeedbackAnswerService {

    private final FeedbackAnswerRepository answerRepo;  
    private final TemplateQuestionRepository questionRepo;
    private final FeedbackResponseRepository responseRepo;

    @Override
    public List<FeedbackAnswerDto> getAllAnswers() {
        return answerRepo.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public FeedbackAnswerDto getAnswerById(Long id) {
        return answerRepo.findById(id)
                .map(this::mapToDto)
                .orElseThrow(() -> new RuntimeException("Answer not found with id: " + id));
    }

    @Override
    public FeedbackAnswerDto saveAnswer(FeedbackAnswerDto dto) {
        TemplateQuestion question = questionRepo.findById(dto.getQuestionId())
                .orElseThrow(() -> new RuntimeException("Question not found"));

        // ⚠ replace 1L with actual responseId from DTO if available
        FeedbackResponse response = responseRepo.findById(1L)
                .orElseThrow(() -> new RuntimeException("Response not found"));

        FeedbackAnswer answer = new FeedbackAnswer();
        answer.setQuestion(question);
        answer.setAnswerText(dto.getAnswerText());
        answer.setResponse(response);

        FeedbackAnswer saved = answerRepo.save(answer);
        return mapToDto(saved);
    }

    @Override
    public void deleteAnswer(Long id) {
        if (!answerRepo.existsById(id)) {
            throw new RuntimeException("Answer not found with id: " + id);
        }
        answerRepo.deleteById(id);
    }

    // Mapper
    private FeedbackAnswerDto mapToDto(FeedbackAnswer answer) {
        return FeedbackAnswerDto.builder()
                .id(answer.getId())
                .questionId(answer.getQuestion().getId())
                .answerText(answer.getAnswerText())
                .build();
    }
}

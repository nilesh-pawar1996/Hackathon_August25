package com.sunbeam.service;

import com.sunbeam.dto.FeedbackAnswerDto;
import java.util.List;

public interface FeedbackAnswerService {
    List<FeedbackAnswerDto> getAllAnswers();
    FeedbackAnswerDto getAnswerById(Long id);
    FeedbackAnswerDto saveAnswer(FeedbackAnswerDto dto);
    void deleteAnswer(Long id);
}

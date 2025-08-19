
package com.sunbeam.service;
import com.sunbeam.dto.FeedbackResponseDto;

import java.util.List;

public interface FeedbackResponseService {
    List<FeedbackResponseDto> getAllResponses();
    FeedbackResponseDto getResponseById(Long id);
    FeedbackResponseDto submitResponse(FeedbackResponseDto dto);
    void deleteResponse(Long id);
}
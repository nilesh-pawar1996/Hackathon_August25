package com.sunbeam.controller;

import com.sunbeam.dto.FeedbackResponseDto;
import com.sunbeam.service.FeedbackResponseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/responses")
@AllArgsConstructor
public class FeedbackResponseController {

    private final FeedbackResponseService responseService;

    // ✅ Get all feedback responses
    @GetMapping
    public ResponseEntity<List<FeedbackResponseDto>> getAllResponses() {
        return ResponseEntity.ok(responseService.getAllResponses());
    }

    // ✅ Get response by ID
    @GetMapping("/{id}")
    public ResponseEntity<FeedbackResponseDto> getResponseById(@PathVariable Long id) {
        return ResponseEntity.ok(responseService.getResponseById(id));
    }

    // ✅ Submit new feedback (student submits answers)
    @PostMapping
    public ResponseEntity<FeedbackResponseDto> submitResponse(@RequestBody FeedbackResponseDto responseDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(responseService.submitResponse(responseDto));
    }
}
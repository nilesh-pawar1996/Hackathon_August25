package com.sunbeam.controller;

import com.sunbeam.dto.FeedbackAnswerDto;
import com.sunbeam.service.FeedbackAnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/answers")
@RequiredArgsConstructor
public class FeedbackAnswerController {

    private final FeedbackAnswerService answerService;

    // 🔹 Get all answers
    @GetMapping
    public ResponseEntity<List<FeedbackAnswerDto>> getAllAnswers() {
        return ResponseEntity.ok(answerService.getAllAnswers());
    }

    // 🔹 Get answer by ID
    @GetMapping("/{id}")
    public ResponseEntity<FeedbackAnswerDto> getAnswerById(@PathVariable Long id) {
        return ResponseEntity.ok(answerService.getAnswerById(id));
    }

    // 🔹 Save new answer
    @PostMapping
    public ResponseEntity<FeedbackAnswerDto> saveAnswer(@RequestBody FeedbackAnswerDto dto) {
        return ResponseEntity.ok(answerService.saveAnswer(dto));
    }

    // 🔹 Delete answer
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAnswer(@PathVariable Long id) {
        answerService.deleteAnswer(id);
        return ResponseEntity.ok("Answer deleted successfully");
    }
}

package com.sunbeam.controller;

import com.sunbeam.dto.FeedbackTemplateDto;
import com.sunbeam.service.FeedbackTemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/templates")
@RequiredArgsConstructor
public class FeedbackTemplateController {

    private final FeedbackTemplateService templateService;

    @GetMapping
    public ResponseEntity<List<FeedbackTemplateDto>> getAllTemplates() {
        return ResponseEntity.ok(templateService.getAllTemplates());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FeedbackTemplateDto> getTemplateById(@PathVariable Long id) {
        return ResponseEntity.ok(templateService.getTemplateById(id));
    }

    @PostMapping
    public ResponseEntity<FeedbackTemplateDto> createTemplate(@RequestBody FeedbackTemplateDto dto) {
        return ResponseEntity.ok(templateService.createTemplate(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTemplate(@PathVariable Long id) {
        templateService.deleteTemplate(id);
        return ResponseEntity.ok("Template deleted successfully");
    }
}
package com.jency.amourboxbackend.controller;

import com.jency.amourboxbackend.dto.MemoryResponseDto;
import com.jency.amourboxbackend.service.MemoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/memories")
@CrossOrigin(origins = "*")
public class MemoryController {

    @Autowired
    private MemoryService memoryService;

    @GetMapping
    public ResponseEntity<List<MemoryResponseDto>> getTimeline() {
        return ResponseEntity.ok(memoryService.getAllMemoriesChronologically());
    }
}

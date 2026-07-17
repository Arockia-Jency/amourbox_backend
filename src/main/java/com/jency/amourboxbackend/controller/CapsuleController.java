package com.jency.amourboxbackend.controller;


import com.jency.amourboxbackend.dto.CapsuleResponseDto;
import com.jency.amourboxbackend.service.CapsuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/capsule")
@CrossOrigin(origins = "*")
public class CapsuleController {

    @Autowired
    private CapsuleService capsuleService;

    @GetMapping("/today")
    public ResponseEntity<CapsuleResponseDto> getDailyMessage() {
        CapsuleResponseDto response = capsuleService.getTodayMessage();
        return ResponseEntity.ok(response);
    }
}

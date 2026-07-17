package com.jency.amourboxbackend.controller;

import com.jency.amourboxbackend.model.ScratchCard;
import com.jency.amourboxbackend.service.ScratchCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/scratch-cards")
public class ScratchCardController {

    @Autowired
    private ScratchCardService scratchCardService;

    @GetMapping("/today")
    public ResponseEntity<ScratchCard> getTodayCard() {
        ScratchCard card = scratchCardService.getTodayScratchCard();
        return ResponseEntity.ok(card);
    }
}
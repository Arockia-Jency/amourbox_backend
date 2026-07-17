package com.jency.amourboxbackend.controller;

import com.jency.amourboxbackend.model.LoveLetter;
import com.jency.amourboxbackend.service.LoveLetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/letters")
public class LoveLetterController {

    @Autowired
    private LoveLetterService loveLetterService;

    // GET: /api/letters?mood=STRESSED
    @GetMapping
    public ResponseEntity<LoveLetter> getLetterByMood(@RequestParam String mood) {
        // Convert to uppercase to prevent case mismatch issues
        LoveLetter letter = loveLetterService.getRandomLetterByMood(mood.toUpperCase());

        if (letter == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(letter);
    }
}


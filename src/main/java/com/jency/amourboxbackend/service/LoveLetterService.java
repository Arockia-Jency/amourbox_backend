package com.jency.amourboxbackend.service;

import com.jency.amourboxbackend.model.LoveLetter;
import com.jency.amourboxbackend.repository.LoveLetterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class LoveLetterService {

    @Autowired
    private LoveLetterRepository loveLetterRepository;

    public LoveLetter getRandomLetterByMood(String mood) {
        List<LoveLetter> letters = loveLetterRepository.findByMoodIgnoreCase(mood);

        if (letters.isEmpty()) {
            // High-quality fallback so the app never breaks
            return new LoveLetter(
                    mood,
                    "A little reminder...",
                    "I might not have written a letter specifically for this mood yet, but remember: I love you unconditionally, always. ❤️"
            );
        }

        // Shuffle the list to return a random one if you wrote multiple letters for the same mood
        Collections.shuffle(letters);
        return letters.get(0);
    }
}
package com.jency.amourboxbackend.service;

import com.jency.amourboxbackend.dto.CapsuleResponseDto;
import com.jency.amourboxbackend.model.Capsule;
import com.jency.amourboxbackend.repository.CapsuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CapsuleService {

    @Autowired
    private CapsuleRepository capsuleRepository;

    // A curated, unique list of messages to make him smile
    private static final List<FallbackQuote> SMILE_POOL = List.of(
            new FallbackQuote("You are my favorite notification. Hope your day is as amazing as your smile! ❤️", "HAPPY"),
            new FallbackQuote("Just a daily reminder that I love you more than curd rice. And that is a LOT.", "PLAYFUL"),
            new FallbackQuote("No matter how tough today gets, remember you have a girl who thinks you are the absolute absolute best. 🥰", "LOVING"),
            new FallbackQuote("Sending you a giant virtual hug right now. Squeeze!!! 🤗", "WAKEY"),
            new FallbackQuote("My day starts perfectly because you are in it. Go conquer the day, my love! 💪", "HAPPY"),
            new FallbackQuote("You make my heart skip a beat (and sometimes run a whole marathon). 💓", "ROMANTIC"),
            new FallbackQuote("Just thinking about you makes me smile like an idiot. Thanks for that! 😜", "PLAYFUL"),
            new FallbackQuote("You are my home and my adventure, all in one. 🏡✨", "LOVING"),
            new FallbackQuote("I’m so incredibly proud of you. Always am, always will be. 😘", "PROUD"),
            new FallbackQuote("If you were a triangle, you'd be acute one. Yes, I just used a math pun. Deal with it! 😂📐", "PLAYFUL")
    );

    public CapsuleResponseDto getTodayMessage() {
        LocalDate today = LocalDate.now();

        // 1. Try to find a custom scheduled capsule for today
        return capsuleRepository.findByUnlockDate(today)
                .map(capsule -> new CapsuleResponseDto(capsule.getMessage(), capsule.getMood()))
                // 2. If none exists, automatically pick one from our smile pool using the day of the year
                .orElseGet(() -> {
                    int dayOfYear = today.getDayOfYear();
                    // Using modulo (%) ensures we rotate safely through the list (0 to 9) every day
                    int index = dayOfYear % SMILE_POOL.size();
                    FallbackQuote fallback = SMILE_POOL.get(index);
                    return new CapsuleResponseDto(fallback.message(), fallback.mood());
                });
    }

    // A simple record to hold fallback data structure easily
    private record FallbackQuote(String message, String mood) {}
}
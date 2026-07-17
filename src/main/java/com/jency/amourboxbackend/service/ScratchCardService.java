package com.jency.amourboxbackend.service;

import com.jency.amourboxbackend.model.ScratchCard;
import com.jency.amourboxbackend.repository.ScratchCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ScratchCardService {

    @Autowired
    private ScratchCardRepository scratchCardRepository;

    public ScratchCard getTodayScratchCard() {
        LocalDate today = LocalDate.now();

        // 1. Check if he already claimed a card today
        Optional<ScratchCard> alreadyClaimedToday = scratchCardRepository.findByClaimedDate(today);
        if (alreadyClaimedToday.isPresent()) {
            return alreadyClaimedToday.get();
        }

        // 2. If not, fetch all available unclaimed cards
        List<ScratchCard> unclaimedCards = scratchCardRepository.findByClaimedFalse();

        if (unclaimedCards.isEmpty()) {
            // Fallback if database pool is empty, so the app doesn't crash
            return new ScratchCard("A giant kiss from me next time we meet! 😘 (Database pool is empty, add more!)", "FALLBACK");
        }

        // 3. Shuffle them to pick one completely at random
        Collections.shuffle(unclaimedCards);
        ScratchCard selectedCard = unclaimedCards.get(0);

        // 4. Mark it as claimed today
        selectedCard.setClaimed(true);
        selectedCard.setClaimedDate(today);

        return scratchCardRepository.save(selectedCard);
    }
}

package com.jency.amourboxbackend.repository;

import com.jency.amourboxbackend.model.ScratchCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ScratchCardRepository extends JpaRepository<ScratchCard, Long> {

    // Find if any card was already claimed today
    Optional<ScratchCard> findByClaimedDate(LocalDate date);

    // Find all unclaimed scratch cards
    List<ScratchCard> findByClaimedFalse();
}

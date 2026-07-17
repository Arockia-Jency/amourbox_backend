package com.jency.amourboxbackend.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "scratch_cards")
public class ScratchCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String reward;
    @Column(nullable = false)
    private String category;

    private boolean claimed = false;

    private LocalDate claimedDate;

    // Constructors
    public ScratchCard() {}

    public ScratchCard(String reward, String category) {
        this.reward = reward;
        this.category = category;
        this.claimed = false;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getReward() { return reward; }
    public void setReward(String reward) { this.reward = reward; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public boolean isClaimed() { return claimed; }
    public void setClaimed(boolean claimed) { this.claimed = claimed; }

    public LocalDate getClaimedDate() { return claimedDate; }
    public void setClaimedDate(LocalDate claimedDate) { this.claimedDate = claimedDate; }
}

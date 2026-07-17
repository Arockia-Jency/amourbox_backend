package com.jency.amourboxbackend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "love_letters")
public class LoveLetter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String mood; // e.g., "STRESSED", "TIRED", "MISSING_ME", "HAPPY"

    @Column(nullable = false, length = 2000) // Support long letter texts
    private String content;

    @Column(nullable = false)
    private String title; // E.g., "Open this when you had a long day"

    // Constructors
    public LoveLetter() {}

    public LoveLetter(String mood, String title, String content) {
        this.mood = mood;
        this.title = title;
        this.content = content;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getMood() { return mood; }
    public void setMood(String mood) { this.mood = mood; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
}

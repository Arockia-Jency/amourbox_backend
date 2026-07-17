package com.jency.amourboxbackend.repository;

import com.jency.amourboxbackend.model.LoveLetter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoveLetterRepository extends JpaRepository<LoveLetter, Long> {
    // Keeps database queries case-insensitive and handles everything we need
    List<LoveLetter> findByMoodIgnoreCase(String mood);
}
package com.jency.amourboxbackend.repository;

import com.jency.amourboxbackend.model.Capsule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface CapsuleRepository extends JpaRepository<Capsule, Long> {

    Optional<Capsule> findByUnlockDate(LocalDate date);
}

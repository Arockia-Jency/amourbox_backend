package com.jency.amourboxbackend.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "capsules")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Capsule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 500)
    private String message;

    @Column(nullable = false)
    private String mood;

    @Column(name = "unlock_date", nullable = false, unique = true)
    private LocalDate unlockDate;
}

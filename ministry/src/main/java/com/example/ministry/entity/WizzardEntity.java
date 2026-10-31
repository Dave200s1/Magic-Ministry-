package com.example.ministry.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;
import java.time.LocalDate;

import jakarta.persistence.Column;

@Entity
@Table(name = "wizzard")
@Getter
@Setter
@NoArgsConstructor
public class WizzardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wizzard_id")
    private Long id;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String first_name;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String last_name;

    @NotNull
    @Column(name = "data_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @NotBlank
    @Column(nullable = false)
    private String blood_status;

    @NotBlank
    @Column(nullable = false)
    private String hogwarts_house;

    @NotEmpty
    @Column(nullable = false)
    private boolean animagus;

    @NotNull
    @Column(name = "registered_at", nullable = false)
    private Instant registeredAt;
}

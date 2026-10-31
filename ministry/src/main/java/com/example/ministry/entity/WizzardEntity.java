package com.example.ministry.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.Instant;
import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

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
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotBlank
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotNull
    @Past
    @Column(name = "data_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "blood_status")
    private String bloodStatus;

    @Column(name = "hogwarts_house")
    private String hogwartsHouse;

    @Column(name = "animagus", nullable = false)
    private boolean animagus = false;

    @CreationTimestamp
    @Column(name = "registered_at", nullable = false, updatable = false)
    private Instant registeredAt;

    @PrePersist
    void applyDefaults() {
        if (bloodStatus == null) {
            bloodStatus = "UNKNOWN";
        }
        if (hogwartsHouse == null) {
            hogwartsHouse = "UNKNOWN";
        }
    }
}

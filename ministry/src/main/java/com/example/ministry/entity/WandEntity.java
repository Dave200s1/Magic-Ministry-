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
@Table(name = "wand")
@Getter
@Setter
@NoArgsConstructor
public class WandEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wand_id")
    private Long id;

    @NotBlank
    @Column(name = "wood", nullable = false)
    String wood;

    @NotBlank
    @Column(name = "core", nullable = false)
    String core;

    @Column(name = "length_inches")
    double length_inches;

    @Column(name = "flexibility")
    String flexibility;

    @Column(name = "maker")
    String maker;

    @PrePersist
    void applyDefaults() {
        if (flexibility == null) {
            flexibility = "UNKNOWN";
        } else if (maker == null) {
            maker = "UNKNOWN";
        } else if (length_inches <= 0.0) {
            length_inches = 0.0;
        }
    }

}

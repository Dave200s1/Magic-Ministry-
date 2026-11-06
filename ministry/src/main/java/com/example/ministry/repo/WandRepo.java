package com.example.ministry.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ministry.entity.WandEntity;

@Repository
public interface WandRepo extends JpaRepository<WandEntity, Long> {
    boolean existsByFirstNameIgnoreCaseAndLastNameIgnoreCase(String wood, String core);
}

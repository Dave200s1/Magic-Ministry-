package com.example.ministry.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.ministry.entity.DepartmentEntity;
import com.example.ministry.entity.WizzardEntity;

@Repository
public interface WizzardRepo extends JpaRepository<WizzardEntity, Long> {
    boolean existsByFirstNameIgnoreCaseAndLastNameIgnoreCase(String firstName, String lastName);
}

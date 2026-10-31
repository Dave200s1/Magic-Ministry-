package com.example.ministry.service;

import com.example.ministry.entity.WizzardEntity;
import com.example.ministry.error.DuplicateResourceException;
import com.example.ministry.error.ResourceNotFoundException;
import com.example.ministry.repo.WizzardRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WizzardService {
    private final WizzardRepo wizzRepo;

    public WizzardService(WizzardRepo wizzReo) {
        this.wizzRepo = wizzReo;
    }

    public WizzardEntity create(WizzardEntity wizzard) {
        if (wizzRepo.existsByFirstNameIgnoreCaseAndLastNameIgnoreCase(wizzard.getFirstName(),
                wizzard.getLastName())) {
            throw new DuplicateResourceException("Wizzard", wizzard.getFirstName() + " " + wizzard.getLastName());
        }

        return wizzRepo.save(wizzard);
    }

    public List<WizzardEntity> findAll() {
        return wizzRepo.findAll();
    }

    public WizzardEntity findByid(Long id) {
        return wizzRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Wizzard", id));
    }
}

package com.example.ministry.service;

import com.example.ministry.entity.DepartmentEntity;
import com.example.ministry.error.DepartmentAlreadyExistsException;
import com.example.ministry.error.DepartmentNotFoundException;
import com.example.ministry.repo.DepartmentRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    private final DepartmentRepo depRepo;

    public DepartmentService(DepartmentRepo depRepo) {
        this.depRepo = depRepo;
    }

    public DepartmentEntity create(DepartmentEntity department) {
        if (depRepo.existsByNameIgnoreCase(department.getName())) {
            throw new DepartmentAlreadyExistsException(department.getName());
        }
        return depRepo.save(department);
    }

    public List<DepartmentEntity> findAll() {
        return depRepo.findAll();
    }

    public DepartmentEntity findById(Long id) {
        return depRepo.findById(id)
                .orElseThrow(() -> new DepartmentNotFoundException(id));
    }
}

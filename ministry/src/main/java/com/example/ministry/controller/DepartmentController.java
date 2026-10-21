package com.example.ministry.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.ministry.entity.DepartmentEntity;
import com.example.ministry.repo.DepartmentRepo;

import java.util.List;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {
    private final DepartmentRepo depRepo;

    public DepartmentController(DepartmentRepo deRepo) {
        this.depRepo = deRepo;
    }

    @PostMapping
    public ResponseEntity<DepartmentEntity> create(@RequestBody DepartmentEntity departmentEntity) {
        DepartmentEntity saved = depRepo.save(departmentEntity);
        return ResponseEntity.status(201).body(saved);
    }

    @GetMapping
    public List<DepartmentEntity> getAll() {
        return depRepo
                .findAll();
    }
}

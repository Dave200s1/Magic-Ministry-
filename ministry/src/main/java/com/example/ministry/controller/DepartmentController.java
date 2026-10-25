package com.example.ministry.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import com.example.ministry.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import com.example.ministry.entity.DepartmentEntity;
import com.example.ministry.repo.DepartmentRepo;

import java.util.List;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<DepartmentEntity> create(@RequestBody DepartmentEntity departmentEntity) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(departmentService.create(departmentEntity));
    }

    @GetMapping
    public List<DepartmentEntity> getAll() {
        return departmentService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentEntity> getById(@PathVariable Long id) {
        return ResponseEntity.ok(departmentService.findById(id));
    }

}

package com.example.ministry.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.ministry.entity.WizzardEntity;
import com.example.ministry.repo.WizzardRepo;
import com.example.ministry.service.WizzardService;

import java.util.List;

@RestController
@RequestMapping("/api/wizzard")
public class WizzardController {
    private final WizzardService wizzardService;

    public WizzardController(WizzardService wizzardService) {
        this.wizzardService = wizzardService;
    }

    @PostMapping
    public ResponseEntity<WizzardEntity> create(@RequestBody WizzardEntity wizzardEntity) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(wizzardService.create(wizzardEntity));
    }

    @GetMapping
    public List<WizzardEntity> getAll() {
        return wizzardService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<WizzardEntity> getById(@PathVariable Long id) {
        return ResponseEntity.ok(wizzardService.findByid(id));
    }
}

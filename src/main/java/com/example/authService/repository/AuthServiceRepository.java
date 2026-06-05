package com.example.authService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.authService.model.authService;



@Repository
public interface AuthServiceRepository extends JpaRepository<authService, Integer> {
}


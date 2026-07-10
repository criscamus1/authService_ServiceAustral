package com.example.authService.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.authService.model.authService;


@Repository
public interface AuthServiceRepository extends JpaRepository<authService, Integer> {
Optional<authService> findByUsername(String username);
List<authService> findByRol(String rol);
}


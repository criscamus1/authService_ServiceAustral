package com.example.authService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor


@Entity
@Table(name = "tabla_credenciales")
public class authService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "username", nullable = false, length = 50, unique = true)
    private String username;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Column(name = "rol", nullable = false, length = 20)
    private String rol; // "TECNICO", "VETERINARIO", "SUPERVISOR"

    @Column(name = "estado", nullable = false, length = 15)
    private String estado; // "ACTIVO", "INACTIVO"
}
package com.example.authService.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateAuthRequest(
    @NotBlank(message = "El nombre de usuario es obligatorio")
    @Size(max = 50, message = "El usuario no puede superar los 50 caracteres")String username,   
    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 8, message = "La contraseña debe tener al menos 6 caracteres")String password,
    @NotBlank(message = "El rol es obligatorio")String rol, // Los roles que pense son "TECNICO", "VETERINARIO", "SUPERVISOR"
    @NotBlank(message = "El estado es obligatorio")
    String estado // "ACTIVO", "INACTIVO"
) {}



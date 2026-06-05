package com.example.dto;
import jakarta.validation.constraints.*;

public record sesionDTO(
    @NotBlank(message = "El nombre de usuario es obligatorio")
    String username,
    @NotBlank(message = "La contraseña es obligatoria")
    String password
) {}

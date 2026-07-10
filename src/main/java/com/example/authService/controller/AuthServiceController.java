package com.example.authService.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.authService.dto.CreateAuthRequest;
import com.example.authService.dto.sesionDTO;
import com.example.authService.model.authService;
import com.example.authService.service.AuthServiceService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthServiceController {
  private final AuthServiceService service;
    public AuthServiceController(AuthServiceService service) {
        this.service = service;
        }
  @GetMapping
    @Operation(summary = "Listar credenciales",
      description = "Obtiene todas las credenciales de acceso registradas en el sistema."
)
    @ApiResponse(responseCode = "200", description = "Lista de credenciales obtenida correctamente")
    public ResponseEntity<List<authService>> listarUsuarios() {
     return ResponseEntity.ok(service.getAllRecursos());
}
  @PostMapping
    @Operation(
     summary = "Registrar credencial",
     description = "Registra una nueva credencial de acceso."
)
      public ResponseEntity<authService> guardarUsuario(@Valid @RequestBody CreateAuthRequest dto) {
            authService nuevoUsuario = service.guardarUsuario(dto);
              return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuario);
        }
   @GetMapping("/{id}")
    @Operation(summary = "Buscar credencial por ID",
      description = "Busca una credencial utilizando su identificador."
    )
    @ApiResponse(responseCode = "200", description = "Credencial encontrada")
    @ApiResponse(responseCode = "404", description = "Credencial no encontrada")
    public ResponseEntity<authService> buscarUsuario(@PathVariable int id) {
      return ResponseEntity.ok(service.buscarUsuario(id));
    }
  @GetMapping("/username/{username}")
    @Operation(summary = "Buscar por nombre de usuario",
      description = "Busca una credencial utilizando el username."
    )
    @ApiResponse(responseCode = "200", description = "Usuario encontrado")
    @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    public ResponseEntity<authService> buscarPorUsername(@PathVariable String username) {
        return ResponseEntity.ok(service.buscarPorUsername(username));
    }
  @GetMapping("/rol/{rol}")
   public ResponseEntity<List<authService>> buscarRol(@PathVariable String rol) {
    List<authService> usuarios = service.buscarRol(rol);
     return ResponseEntity.ok(usuarios);
}
  @GetMapping("/estado/{username}")
    public ResponseEntity<String> verificarEstado(@PathVariable String username) {
      String estado = service.verificarEstado(username);
        return ResponseEntity.ok(estado);
}
  @PutMapping("/{id}")
    @Operation(
      summary = "Actualizar credencial",
      description = "Actualiza la información de una credencial existente."
)
    public ResponseEntity<authService> actualizarUsuario(@PathVariable int id, 
      @Valid @RequestBody CreateAuthRequest dto) {
        authService usuarioActualizado = service.actualizarUsuario(id, dto);
          return ResponseEntity.ok(usuarioActualizado);
        }
    @PostMapping("/login")
    @Operation( summary = "Iniciar sesión",
        description = "Valida el nombre de usuario y la contraseña para acceder al sistema."
    )
    @ApiResponse(responseCode = "200", description = "Inicio de sesión exitoso")
    @ApiResponse(responseCode = "401", description = "Credenciales inválidas")
    public ResponseEntity<authService> login(@Valid @RequestBody sesionDTO dto) {
        return ResponseEntity.ok(service.login(dto));
    }
}

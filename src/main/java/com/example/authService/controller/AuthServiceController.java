package com.example.authService.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.authService.dto.CreateAuthRequest;
import com.example.authService.dto.sesionDTO;
import com.example.authService.model.authService;
import com.example.authService.service.AuthServiceService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthServiceController {
      private final AuthServiceService service;
      public AuthServiceController(AuthServiceService service) {
          this.service = service;
        }
        @GetMapping
      public ResponseEntity<List<authService>> listarUsuarios() {
          List<authService> usuarios = service.getAllRecursos();
          return ResponseEntity.ok(usuarios);
        }
        @PostMapping
      public ResponseEntity<authService> guardarUsuario(@Valid @RequestBody CreateAuthRequest dto) {
            authService nuevoUsuario = service.guardarUsuario(dto);
              return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuario);
        }
        @GetMapping("{id}")
        public ResponseEntity<authService> buscarUsuario(@PathVariable int id) {
            authService usuario = service.buscarUsuario(id);
              return ResponseEntity.ok(usuario);
        }
        @PutMapping("{id}")
        public ResponseEntity<authService> actualizarUsuario(@PathVariable int id, 
        @Valid @RequestBody CreateAuthRequest dto) {
            authService usuarioActualizado = service.actualizarUsuario(id, dto);
              return ResponseEntity.ok(usuarioActualizado);
        }
        @DeleteMapping("{id}")
        public ResponseEntity<Void> eliminarUsuario(@PathVariable int id) {
            service.eliminarUsuario(id);
             return ResponseEntity.noContent().build(); 
        }
        @PostMapping("/login")
        public ResponseEntity<authService> login(@Valid @RequestBody sesionDTO dto) {
            authService usuarioAutenticado = service.login(dto);
              return ResponseEntity.ok(usuarioAutenticado);
        }
}

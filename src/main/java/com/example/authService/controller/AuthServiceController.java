package com.example.authService.controller;

import com.example.authService.model.authService;
import com.example.authService.service.AuthServiceService;
import com.example.dto.sesionDTO;

import jakarta.validation.Valid;

import  org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;





@RestController
@RequestMapping("/authService")
public class AuthServiceController {
@Autowired
  private AuthServiceService service;
@GetMapping
 public List<authService> obtenerAuthService() {
  return service.obtenerAuthService();
}
//@PostMapping("/ingresar")
 //public authService login(@Valid @RequestBody sesionDTO dto) {  no supe seguir con esto 
  //return service.iniciarSesion(dto.username(), dto.password());
//}
@GetMapping("/{id}")
 public authService buscarAuthService(@PathVariable int id) {
  return service.buscaAuthService(id);
}
@PostMapping
 public authService guardarAuthService(@RequestBody authService authServ) {
  return service.guardar(authServ);
}
@PutMapping
 public authService actualizarAuthService(@RequestBody authService authServ) {
  return service.actualizarAuthService(authServ);
}
@DeleteMapping("/{id}")
 public String eliminarAuthService(@PathVariable int id) {
  return service.eliminar(id);
}


}

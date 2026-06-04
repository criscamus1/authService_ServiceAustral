package com.example.authService.controller;

import com.example.authService.model.authService;
import com.example.authService.service.AuthServiceService;

import  org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;





@RestController
@RequestMapping("/authService")
public class AuthServiceController {
@Autowired
private AuthServiceService service;

@GetMapping
public List<authService>obtenerAuthService(){
    return service.obtenerAuthService();
}
@GetMapping("/{id}")
public authService buscarAuthService(int id){
    return service.buscaAuthService(id);
}
@PostMapping
public authService guardarAuthService(@RequestBody authService authServ){
    return service.guardar(authServ);
}
@PutMapping
public authService actualizarAuthService(@RequestBody authService authServ){
    return service.actualizarAuthService(authServ);
}
@DeleteMapping("/{id}")
public void eliminarAuthService(@PathVariable int id){
    service.eliminar(id);
}


}

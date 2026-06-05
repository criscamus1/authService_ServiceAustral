package com.example.authService.service;

import com.example.authService.model.authService;
import com.example.authService.repository.AuthServiceRepository;
import com.example.exception.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthServiceService {
@Autowired
private AuthServiceRepository repository;

public List<authService> obtenerAuthService() {
  return repository.findAll();
}
 public authService buscaAuthService(int id) {
    return repository.findById(id).orElseThrow(() -> new exception("Registro de credencial no fueron encontrados"));
}
 public authService guardar(authService authServ) {
        return repository.save(authServ);
}
 public authService actualizarAuthService(authService authServ) {
    buscaAuthService(authServ.getId()) ;
     return repository.save(authServ);
}
public String eliminar(int id) {
  buscaAuthService(id);
   repository.deleteById(id);
   return "El trabajador ya no pertenece a la empresa, ha sido borrad@";
}
}

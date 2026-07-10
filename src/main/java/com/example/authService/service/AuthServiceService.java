package com.example.authService.service;



import com.example.exception.exception;
import com.example.authService.dto.CreateAuthRequest;
import com.example.authService.dto.sesionDTO;
import com.example.authService.model.authService;
import com.example.authService.repository.AuthServiceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;

@Service
public class AuthServiceService {
 @Autowired
 private AuthServiceRepository repository;
 public List<authService> getAllRecursos(){
   return repository.findAll();
 }
    public authService buscarUsuario(int id){ 
        return repository.findById(id)
                .orElseThrow(() -> new exception("La credencial no fue encontrada"));
    }
public authService guardarUsuario(CreateAuthRequest dto) {
    repository.findByUsername(dto.username())
            .ifPresent(u -> {throw new exception("El nombre de usuario ya existe");
            });
    authService usuario = new authService();
    usuario.setUsername(dto.username());
    usuario.setPassword(dto.password());
    usuario.setRol(dto.rol().toUpperCase());
    usuario.setEstado(dto.estado().toUpperCase());

    return repository.save(usuario);
    }
    public authService actualizarUsuario(int id, CreateAuthRequest dto){ 
        authService usuario = buscarUsuario(id);
        usuario.setUsername(dto.username());
        usuario.setPassword(dto.password());
        usuario.setRol(dto.rol());
        usuario.setEstado(dto.estado());
        return repository.save(usuario);
    }

public List<authService> buscarRol(String rol){
    List<authService> usuarios = repository.findByRol(rol.toUpperCase());
    if(usuarios.isEmpty()){throw new exception("No existen usuarios con ese rol");
    }
    return usuarios;
}
public authService buscarPorUsername(String username){
    return repository.findByUsername(username).orElseThrow(() -> new exception("Usuario no encontrado"));
}
public String verificarEstado(String username){
    authService usuario = repository.findByUsername(username).orElseThrow(() -> new exception("Usuario no encontrado"));
    return usuario.getEstado();
}
public authService login(sesionDTO dto) {
    authService usuario = repository.findByUsername(dto.username()).orElseThrow(() -> new exception("Nombre de usuario o contraseña incorrectos"));
    if(!usuario.getPassword().equals(dto.password())){
        throw new exception("Nombre de usuario o contraseña incorrectos");
    }
    if(usuario.getEstado().equalsIgnoreCase("INACTIVO")){
        throw new exception("La cuenta se encuentra inactiva");
    }
    return usuario;
}
}
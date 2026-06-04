package com.example.authService.service;

import com.example.authService.model.authService;
import com.example.authService.repository.AuthServiceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthServiceService {
@Autowired
private AuthServiceRepository repository;

//public authService iniciarSesion(String user,String password){

//}


public List <authService >obtenerAuthService(){
    return repository.obtenerAuthService();
}
public authService buscaAuthService( int id){
    return repository.buscarAuthServiceId(id);
}
public authService guardar(authService authServ){
    return repository.guardar(authServ);
}
public authService actualizarAuthService(authService authServ){
    return repository.actualizar(authServ);
}
public String eliminar(int id){
    repository.eliminar(id);
    return "El trabajador ya no pertenece a la empresa, ha sido borrad@";
}

}

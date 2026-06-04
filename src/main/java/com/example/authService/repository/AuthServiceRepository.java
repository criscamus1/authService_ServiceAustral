package com.example.authService.repository;

import org.springframework.stereotype.Repository;

import com.example.authService.model.authService;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AuthServiceRepository {
private List<authService>listaAuthService=new ArrayList<>();

public List<authService> obtenerAuthService(){
    return listaAuthService;
}
public authService buscarAuthServiceId(int id){
    for(authService authServ:listaAuthService){
        if(authServ.getId()==id){
            return authServ;
        }
    }
    return null;
}
public authService actualizar(authService authServ){
    int id=0;
    int idPosicion=0;

    for(int i=0;i<listaAuthService.size();i++){
        if(listaAuthService.get(i).getId()==authServ.getId()){
            id=authServ.getId();
            idPosicion=1;
        }
    }
    authService authServ1=new authService();
    authServ1.setId(id);
    authServ1.setUsername(authServ1.getUsername());
    authServ1.setPassword(authServ1.getPassword());
    authServ1.setRol(authServ1.getRol());
    authServ1.setEstado(authServ1.getEstado());
    listaAuthService.set(idPosicion, authServ1);
    return authServ1;
}
public authService guardar(authService authServ){
    listaAuthService.add(authServ);
        return authServ;
}
public void eliminar(int id){
    authService authServ=buscarAuthServiceId(id);
    if(authServ!=null){
        listaAuthService.remove(authServ);
    }
}

}

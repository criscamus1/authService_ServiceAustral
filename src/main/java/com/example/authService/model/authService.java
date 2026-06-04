package com.example.authService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class authService {
private int id;
private String username;
private String password;
private String rol;
private String estado;
}

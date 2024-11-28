package com.bancorealcash.app.BancoRealCash.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


//todo: ELMINAR
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Usuarios")
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer UsuarioID;
    private String Nombre;
    private String Apellido;
    private String Correo;
    private String Telefono;
    private String DNI;
    private String Direccion;
    private LocalDateTime FechaRegistro;
}

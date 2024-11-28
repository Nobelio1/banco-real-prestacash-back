package com.bancorealcash.app.BancoRealCash.entities;


import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuario_informacion")
public class UsuarioInformacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer usuarioId;

    @Column(length = 50)
    private String nombres;

    @Column(length = 100)
    private String apellidos;

    @Column(length = 50)
    private String correo;

    @Column(length = 10)
    private String celular;

    @Column(length = 10)
    private String dni;

    @Column(length = 100)
    private String direccion;

}

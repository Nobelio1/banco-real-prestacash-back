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
    @Column(name = "usuario_id")
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

    @OneToOne
    @MapsId
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

}

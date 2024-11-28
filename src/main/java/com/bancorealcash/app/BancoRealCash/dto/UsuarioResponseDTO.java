package com.bancorealcash.app.BancoRealCash.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioResponseDTO {
    private Integer usuarioId;
    private String correo;
    private String nombres;
    private String apellidos;
    private String celular;
    private String dni;
    private String direccion;
    private String rol;
}

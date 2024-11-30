package com.bancorealcash.app.BancoRealCash.service;

import com.bancorealcash.app.BancoRealCash.dto.SesionResponseDTO;
import com.bancorealcash.app.BancoRealCash.dto.UsuarioDTO;

public interface SesionService {
    SesionResponseDTO registrar(UsuarioDTO usuario);
    SesionResponseDTO validarUsuario(String correo, String contrasena);
}

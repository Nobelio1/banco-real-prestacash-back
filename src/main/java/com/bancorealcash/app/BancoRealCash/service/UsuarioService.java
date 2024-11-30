package com.bancorealcash.app.BancoRealCash.service;


import com.bancorealcash.app.BancoRealCash.dto.ResponseDTO;
import com.bancorealcash.app.BancoRealCash.dto.UsuarioResponseDTO;

public interface UsuarioService {
    ResponseDTO<UsuarioResponseDTO> informacionUsuario(Integer id);
    void guardarUsuarioInformacion(UsuarioResponseDTO usuarioResponseDTO);
}

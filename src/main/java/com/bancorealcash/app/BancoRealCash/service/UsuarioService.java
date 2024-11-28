package com.bancorealcash.app.BancoRealCash.service;


import com.bancorealcash.app.BancoRealCash.dto.ResponseDTO;
import com.bancorealcash.app.BancoRealCash.dto.UsuarioResponseDTO;

public interface UsuarioService {
    public ResponseDTO<UsuarioResponseDTO> informacionUsuario(Integer id);
}

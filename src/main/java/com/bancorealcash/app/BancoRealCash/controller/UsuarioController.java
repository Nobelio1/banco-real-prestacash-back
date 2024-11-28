package com.bancorealcash.app.BancoRealCash.controller;

import com.bancorealcash.app.BancoRealCash.dto.ResponseDTO;
import com.bancorealcash.app.BancoRealCash.dto.UsuarioResponseDTO;
import com.bancorealcash.app.BancoRealCash.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("informacion/{id}")
    public ResponseEntity<ResponseDTO<UsuarioResponseDTO>> informacionUsuario(@PathVariable Integer id) {
        ResponseDTO<UsuarioResponseDTO> response = usuarioService.informacionUsuario(id);
        return ResponseEntity.ok(response);
    }


}

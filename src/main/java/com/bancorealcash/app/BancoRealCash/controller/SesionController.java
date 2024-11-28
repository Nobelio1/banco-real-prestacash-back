package com.bancorealcash.app.BancoRealCash.controller;

import com.bancorealcash.app.BancoRealCash.dto.UsuarioDTO;
import com.bancorealcash.app.BancoRealCash.service.SesionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sesion")
public class SesionController {

    @Autowired
    private SesionService sesionService;

    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody UsuarioDTO usuario) {
        return ResponseEntity.ok("Sesion Inicia correctamente");
    }

    @PostMapping("register")
    public ResponseEntity<String> registrar(@RequestBody UsuarioDTO usuario) {
        sesionService.registrar(usuario);
        return ResponseEntity.ok("Se registro correctamente");
    }

    //token , refresh-token
}

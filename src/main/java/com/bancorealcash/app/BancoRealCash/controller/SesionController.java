package com.bancorealcash.app.BancoRealCash.controller;

import com.bancorealcash.app.BancoRealCash.dto.ResponseDTO;
import com.bancorealcash.app.BancoRealCash.dto.SesionResponseDTO;
import com.bancorealcash.app.BancoRealCash.dto.SolicitudResponseDTO;
import com.bancorealcash.app.BancoRealCash.dto.UsuarioDTO;
import com.bancorealcash.app.BancoRealCash.service.SesionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("sesion")
public class SesionController {

    @Autowired
    private SesionService sesionService;

    @PostMapping("login")
    public ResponseEntity<ResponseDTO<?>> login(@RequestBody UsuarioDTO usuarioDTO) {
        try {
            SesionResponseDTO loginUser = sesionService.validarUsuario(usuarioDTO.getCorreo(), usuarioDTO.getContrasena());
            ResponseDTO<SesionResponseDTO> response = ResponseDTO.<SesionResponseDTO>builder()
                    .code("000")
                    .data(loginUser)
                    .build();
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            ResponseDTO<String> response = ResponseDTO.<String>builder()
                    .code("999")
                    .data(e.getMessage())
                    .build();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PostMapping("register")
    public ResponseEntity<?> registrar(@RequestBody UsuarioDTO usuario) {
        sesionService.registrar(usuario);
        try {
            SesionResponseDTO registerUser = sesionService.registrar(usuario);
            ResponseDTO<SesionResponseDTO> response = ResponseDTO.<SesionResponseDTO>builder()
                    .code("000")
                    .data(registerUser)
                    .build();
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            ResponseDTO<String> response = ResponseDTO.<String>builder()
                    .code("999")
                    .data(e.getMessage())
                    .build();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}

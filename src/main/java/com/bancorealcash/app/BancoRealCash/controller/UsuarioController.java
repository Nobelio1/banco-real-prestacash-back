package com.bancorealcash.app.BancoRealCash.controller;

import com.bancorealcash.app.BancoRealCash.dto.ResponseDTO;
import com.bancorealcash.app.BancoRealCash.dto.UsuarioResponseDTO;
import com.bancorealcash.app.BancoRealCash.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/guardar-informacion")
    public ResponseEntity<ResponseDTO<String>> guardarUsuarioInformacion(@RequestBody UsuarioResponseDTO usuarioResponseDTO) {
        try {
            usuarioService.guardarUsuarioInformacion(usuarioResponseDTO);
            ResponseDTO<String> response = ResponseDTO.<String>builder()
                    .code("000")
                    .data("La información del usuario se guardó correctamente.")
                    .build();
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            ResponseDTO<String> response = ResponseDTO.<String>builder()
                    .code("999")
                    .data("Error al guardar la información del usuario.")
                    .build();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }


    @GetMapping("informacion/{id}")
    public ResponseEntity<ResponseDTO<UsuarioResponseDTO>> informacionUsuario(@PathVariable Integer id) {
        ResponseDTO<UsuarioResponseDTO> response = usuarioService.informacionUsuario(id);
        return ResponseEntity.ok(response);
    }


}

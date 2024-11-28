package com.bancorealcash.app.BancoRealCash.controller;

import com.bancorealcash.app.BancoRealCash.dto.EstadoRequestDTO;
import com.bancorealcash.app.BancoRealCash.dto.MoraRequestDTO;
import com.bancorealcash.app.BancoRealCash.dto.PrestamoDTO;
import com.bancorealcash.app.BancoRealCash.dto.ResponseDTO;
import com.bancorealcash.app.BancoRealCash.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("prestamo")
public class PrestamoController {

    @Autowired
    private PrestamoService prestamoService;

    @GetMapping("listar")
    public ResponseEntity<ResponseDTO<List<PrestamoDTO>>> listarPrestamos() {
        try {
            List<PrestamoDTO> prestamos = prestamoService.obtenerTodosLosPrestamos();

            ResponseDTO<List<PrestamoDTO>> response = ResponseDTO.<List<PrestamoDTO>>builder()
                    .code("000")
                    .data(prestamos)
                    .build();

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            ResponseDTO<List<PrestamoDTO>> errorResponse = ResponseDTO.<List<PrestamoDTO>>builder()
                    .code("999")
                    .data(Collections.emptyList())
                    .build();

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @PostMapping("/actualizar-mora")
    public ResponseEntity<ResponseDTO<String>> actualizarMora(@RequestBody MoraRequestDTO moraRequest) {
        try {
            boolean actualizado = prestamoService.actualizarMora(moraRequest.getPrestamoId(), moraRequest.getMora());

            ResponseDTO<String> response = ResponseDTO.<String>builder()
                    .code(actualizado ? "000" : "999")
                    .data(actualizado ? "Mora actualizada correctamente" : "Error al actualizar la mora")
                    .build();

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            ResponseDTO<String> errorResponse = ResponseDTO.<String>builder()
                    .code("999")
                    .data("Error interno al procesar la solicitud")
                    .build();

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @PutMapping("/actualizar-estado")
    public ResponseEntity<ResponseDTO<String>> actualizarEstado(@RequestBody EstadoRequestDTO estadoRequest) {
        try {
            boolean actualizado = prestamoService.actualizarEstado(estadoRequest.getPrestamoId(), estadoRequest.getEstado());

            ResponseDTO<String> response = ResponseDTO.<String>builder()
                    .code(actualizado ? "000" : "999")
                    .data(actualizado ? "Estado actualizado correctamente" : "Error al actualizar el estado")
                    .build();

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            ResponseDTO<String> errorResponse = ResponseDTO.<String>builder()
                    .code("999")
                    .data("Error interno al procesar la solicitud")
                    .build();

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

}

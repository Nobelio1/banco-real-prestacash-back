package com.bancorealcash.app.BancoRealCash.controller;

import com.bancorealcash.app.BancoRealCash.dto.ContratoDTO;
import com.bancorealcash.app.BancoRealCash.dto.ResponseDTO;
import com.bancorealcash.app.BancoRealCash.entities.Contrato;
import com.bancorealcash.app.BancoRealCash.service.ContratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("contrato")
public class ContratoController {

    @Autowired
    private ContratoService contratoService;

    @GetMapping("/generar/{solicitudId}")
    public ResponseEntity<ResponseDTO<String>> generarContrato(@PathVariable Integer solicitudId) {
        try {
            contratoService.generarContrato(solicitudId);
            ResponseDTO<String> response = ResponseDTO.<String>builder()
                    .code("000")
                    .data("Contrato creado correctamente")
                    .build();
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            ResponseDTO<String> errorResponse = ResponseDTO.<String>builder()
                    .code("999")
                    .data("Error al generar contrato: " + e.getMessage())
                    .build();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @GetMapping("/{solicitudId}")
    public ResponseEntity<ResponseDTO<Contrato>> obtenerContratoPorSolicitud(@PathVariable Integer solicitudId) {
        try {
            Contrato contrato = contratoService.obtenerContratoPorSolicitud(solicitudId);
            ResponseDTO<Contrato> response = ResponseDTO.<Contrato>builder()
                    .code("000")
                    .data(contrato)
                    .build();
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            ResponseDTO<Contrato> errorResponse = ResponseDTO.<Contrato>builder()
                    .code("999")
                    .data(null)
                    .build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

    @PostMapping("/actualizar")
    public ResponseEntity<ResponseDTO<Contrato>> actualizarEstadoYFecha(@RequestBody ContratoDTO contratoDTO) {
        try {
            Contrato contratoActualizado = contratoService.actualizarEstadoYFecha(contratoDTO);
            ResponseDTO<Contrato> response = ResponseDTO.<Contrato>builder()
                    .code("000")
                    .data(contratoActualizado)
                    .build();
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            ResponseDTO<Contrato> errorResponse = ResponseDTO.<Contrato>builder()
                    .code("999")
                    .data(null)
                    .build();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

}

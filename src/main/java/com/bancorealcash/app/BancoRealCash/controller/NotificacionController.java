package com.bancorealcash.app.BancoRealCash.controller;

import com.bancorealcash.app.BancoRealCash.dto.NotificacionDTO;
import com.bancorealcash.app.BancoRealCash.dto.NotificacionResponseDTO;
import com.bancorealcash.app.BancoRealCash.dto.ResponseDTO;
import com.bancorealcash.app.BancoRealCash.service.NotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("notificacion")
public class NotificacionController {

    @Autowired
    private NotificacionService notificacionService;

    @PostMapping("/crear")
    public ResponseEntity<ResponseDTO<String>> crearNotificacion(@RequestBody NotificacionDTO notificacionDTO) {
        try {
            notificacionService.crearNotificacion(notificacionDTO);

            ResponseDTO<String> response = ResponseDTO.<String>builder().code("000").data("Notificación creada correctamente.").build();

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            ResponseDTO<String> errorResponse = ResponseDTO.<String>builder().code("999").data("Error al crear la notificación.").build();

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

    @GetMapping("/{usuarioId}")
    public ResponseEntity<ResponseDTO<List<NotificacionResponseDTO>>> listarNotificaciones(@PathVariable Integer usuarioId) {
        try {
            List<NotificacionResponseDTO> notificaciones = notificacionService.obtenerNotificacionesPorUsuarioId(usuarioId);

            ResponseDTO<List<NotificacionResponseDTO>> response = ResponseDTO.<List<NotificacionResponseDTO>>builder()
                    .code("000")
                    .data(notificaciones)
                    .build();

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            ResponseDTO<List<NotificacionResponseDTO>> errorResponse = ResponseDTO.<List<NotificacionResponseDTO>>builder()
                    .code("999")
                    .data(Collections.emptyList())
                    .build();

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }
}

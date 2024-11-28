package com.bancorealcash.app.BancoRealCash.controller;

import com.bancorealcash.app.BancoRealCash.dto.EstadoFinancieroDTO;
import com.bancorealcash.app.BancoRealCash.dto.ResponseDTO;
import com.bancorealcash.app.BancoRealCash.dto.SolicitudDTO;
import com.bancorealcash.app.BancoRealCash.entities.HistorialCrediticio;
import com.bancorealcash.app.BancoRealCash.entities.Solicitud;
import com.bancorealcash.app.BancoRealCash.service.SolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("solicitud")
public class SolicitudController {

    @Autowired
    private SolicitudService solicitudService;

    @PostMapping("crear")
    public ResponseEntity<?> crearSolicitud(@RequestBody SolicitudDTO solicitudDTO) {
        solicitudService.crearSolicitud(solicitudDTO);
        return ResponseEntity.ok().build(); //cambiar el return
    }

    @GetMapping("listar")
    public ResponseEntity<ResponseDTO<?>> listarSolicitudes() {
        try {
            List<Solicitud> solicitudes = solicitudService.listarSolicitudes();
            ResponseDTO<List<Solicitud>> response = ResponseDTO.<List<Solicitud>>builder()
                    .code("000")
                    .data(solicitudes)
                    .build();
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            ResponseDTO<String> errorResponse = ResponseDTO.<String>builder()
                    .code("999")
                    .data("Error al obtener las solicitudes: " + e.getMessage())
                    .build();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @PostMapping("actualizar-estado-finan")
    public ResponseEntity<ResponseDTO<?>> actualizarEstadoFinan(@RequestBody EstadoFinancieroDTO estadoFinancieroDTO) {
        try {
            solicitudService.actualizarEstadoFinan(estadoFinancieroDTO.getSolicitudId(), estadoFinancieroDTO.getEstadoFinan());
            ResponseDTO<String> response = ResponseDTO.<String>builder()
                    .code("000")
                    .data("Estado financiero actualizado correctamente")
                    .build();
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            ResponseDTO<String> errorResponse = ResponseDTO.<String>builder()
                    .code("999")
                    .data("Error al actualizar el estado financiero: " + e.getMessage())
                    .build();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @PostMapping("actualizar-estado-credito")
    public ResponseEntity<ResponseDTO<?>> cambiarEstadoCredito(@RequestBody EstadoFinancieroDTO estadoFinancieroDTO) {
        try {
            solicitudService.actualizarEstadoCredito(estadoFinancieroDTO.getSolicitudId(), estadoFinancieroDTO.getEstadoFinan());
            ResponseDTO<String> response = ResponseDTO.<String>builder()
                    .code("000")
                    .data("Credito actualizado correctamente")
                    .build();
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            ResponseDTO<String> errorResponse = ResponseDTO.<String>builder()
                    .code("999")
                    .data("Error al actualizar el estado financiero: " + e.getMessage())
                    .build();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @PostMapping("actualizar-estado-final")
    public ResponseEntity<ResponseDTO<?>> actualizarOficialCredito(@RequestBody EstadoFinancieroDTO estadoFinancieroDTO) {
        try {
            solicitudService.actualizarOficialCredito(estadoFinancieroDTO.getSolicitudId(), estadoFinancieroDTO.getEstadoFinan());
            ResponseDTO<String> response = ResponseDTO.<String>builder()
                    .code("000")
                    .data("Credito actualizado correctamente")
                    .build();
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            ResponseDTO<String> errorResponse = ResponseDTO.<String>builder()
                    .code("999")
                    .data("Error al actualizar el estado financiero: " + e.getMessage())
                    .build();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @GetMapping("score/{usuarioId}")
    public ResponseEntity<ResponseDTO<?>> reviarScore(@PathVariable Integer usuarioId) {
        try {
            HistorialCrediticio historial = solicitudService.obtenerOInsertarHistorial(usuarioId);
            ResponseDTO<HistorialCrediticio> response = ResponseDTO.<HistorialCrediticio>builder()
                    .code("000")
                    .data(historial)
                    .build();
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            ResponseDTO<String> errorResponse = ResponseDTO.<String>builder()
                    .code("999")
                    .data("Error al obtener o insertar historial crediticio: " + e.getMessage())
                    .build();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

}

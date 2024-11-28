package com.bancorealcash.app.BancoRealCash.controller;

import com.bancorealcash.app.BancoRealCash.dto.PagoRequestDTO;
import com.bancorealcash.app.BancoRealCash.dto.ResponseDTO;
import com.bancorealcash.app.BancoRealCash.entities.Pago;
import com.bancorealcash.app.BancoRealCash.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pago")
public class PagoController {

    @Autowired
    private PagoService pagoService;

    @PostMapping("/agregar")
    public ResponseEntity<ResponseDTO<String>> agregarPago(@RequestBody PagoRequestDTO pagoRequest) {
        try {
            boolean pagoRegistrado = pagoService.registrarPago(pagoRequest);

            ResponseDTO<String> response = ResponseDTO.<String>builder()
                    .code(pagoRegistrado ? "000" : "999")
                    .data(pagoRegistrado ? "Pago registrado correctamente" : "Error al registrar el pago")
                    .build();

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            ResponseDTO<String> errorResponse = ResponseDTO.<String>builder()
                    .code("999")
                    .data("Error interno al procesar el pago")
                    .build();

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @GetMapping("/prestamo/{prestamoId}")
    public ResponseEntity<ResponseDTO<List<Pago>>> obtenerPagosPorPrestamo(@PathVariable Integer prestamoId) {
        try {
            List<Pago> pagos = pagoService.obtenerPagosPorPrestamo(prestamoId);

            ResponseDTO<List<Pago>> response = ResponseDTO.<List<Pago>>builder()
                    .code(pagos.isEmpty() ? "999" : "000")
                    .data(pagos.isEmpty() ? null : pagos)
                    .build();

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            ResponseDTO<List<Pago>> errorResponse = ResponseDTO.<List<Pago>>builder()
                    .code("999")
                    .data(null)
                    .build();

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }
}

package com.bancorealcash.app.BancoRealCash.service;

import com.bancorealcash.app.BancoRealCash.dto.PrestamoDTO;
import com.bancorealcash.app.BancoRealCash.dto.PrestamoNDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PrestamoService {
    ResponseEntity<?> crearPrestamo(PrestamoNDTO prestamo);
    List<PrestamoDTO> obtenerTodosLosPrestamos();
    boolean actualizarMora(Integer prestamoId, Integer mora);
    boolean actualizarEstado(Integer prestamoId, String estado);
}

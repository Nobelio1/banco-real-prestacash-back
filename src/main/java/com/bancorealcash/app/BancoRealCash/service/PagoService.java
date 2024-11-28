package com.bancorealcash.app.BancoRealCash.service;

import com.bancorealcash.app.BancoRealCash.dto.PagoRequestDTO;
import com.bancorealcash.app.BancoRealCash.entities.Pago;

import java.util.List;

public interface PagoService {
    boolean registrarPago(PagoRequestDTO pagoRequest);
    List<Pago> obtenerPagosPorPrestamo(Integer prestamoId);
}

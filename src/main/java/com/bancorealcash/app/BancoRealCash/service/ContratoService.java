package com.bancorealcash.app.BancoRealCash.service;

import com.bancorealcash.app.BancoRealCash.dto.ContratoDTO;
import com.bancorealcash.app.BancoRealCash.dto.ContratoResponseDTO;
import com.bancorealcash.app.BancoRealCash.entities.Contrato;

public interface ContratoService {
    void generarContrato(Integer solicitudId);
    ContratoResponseDTO obtenerContratoPorSolicitud(Integer solicitudId);
    Contrato actualizarEstadoYFecha(ContratoDTO contratoDTO);

}

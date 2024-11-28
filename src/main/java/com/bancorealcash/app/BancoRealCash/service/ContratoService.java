package com.bancorealcash.app.BancoRealCash.service;

import com.bancorealcash.app.BancoRealCash.dto.ContratoDTO;
import com.bancorealcash.app.BancoRealCash.entities.Contrato;

public interface ContratoService {
    public void generarContrato(Integer solicitudId);
    public Contrato obtenerContratoPorSolicitud(Integer solicitudId);
    public Contrato actualizarEstadoYFecha(ContratoDTO contratoDTO);

}

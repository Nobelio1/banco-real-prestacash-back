package com.bancorealcash.app.BancoRealCash.service;

import com.bancorealcash.app.BancoRealCash.dto.HistorialCrediticioResponseDTO;
import com.bancorealcash.app.BancoRealCash.dto.SolicitudDTO;
import com.bancorealcash.app.BancoRealCash.dto.SolicitudResponseDTO;
import com.bancorealcash.app.BancoRealCash.entities.HistorialCrediticio;
import com.bancorealcash.app.BancoRealCash.entities.Solicitud;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SolicitudService {

    public ResponseEntity<?> crearSolicitud(SolicitudDTO solicitud);
    public List<SolicitudResponseDTO> listarSolicitudes();
    public void actualizarEstadoFinan(Integer solicitudId, String estadoFinan);
    public void actualizarEstadoCredito(Integer solicitudId, String estadoCredito);
    public void actualizarOficialCredito(Integer solicitudId, String oficialCredito);
    public HistorialCrediticioResponseDTO obtenerOInsertarHistorial(Integer usuarioId);
    public SolicitudResponseDTO obtenerSolicitudPorId(Integer id);
}

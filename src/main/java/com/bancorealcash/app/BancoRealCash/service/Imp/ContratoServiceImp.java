package com.bancorealcash.app.BancoRealCash.service.Imp;

import com.bancorealcash.app.BancoRealCash.dto.ContratoDTO;
import com.bancorealcash.app.BancoRealCash.entities.Contrato;
import com.bancorealcash.app.BancoRealCash.entities.Solicitud;
import com.bancorealcash.app.BancoRealCash.repository.ContratoRepository;
import com.bancorealcash.app.BancoRealCash.repository.SolicitudRepository;
import com.bancorealcash.app.BancoRealCash.service.ContratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;


@Service
public class ContratoServiceImp implements ContratoService {

    @Autowired
    private ContratoRepository contratoRepository;

    @Autowired
    private SolicitudRepository solicitudRepository;

    @Override
    public void generarContrato(Integer solicitudId) {
        Solicitud solicitud = solicitudRepository.findById(solicitudId).orElseThrow(() -> new RuntimeException("Solicitud no encontrada"));

        Contrato nuevoContrato = new Contrato();
        nuevoContrato.setSolicitud(solicitud);
        nuevoContrato.setEstado(null);
        nuevoContrato.setFechaPago(null);
        nuevoContrato.setFechaCreacion(new Date());

        contratoRepository.save(nuevoContrato);
    }

    @Override
    public Contrato obtenerContratoPorSolicitud(Integer solicitudId) {
        return contratoRepository.findBySolicitudId(solicitudId).orElseThrow(() -> new RuntimeException("Contrato no encontrado para la solicitud especificada"));
    }

    @Override
    public Contrato actualizarEstadoYFecha(ContratoDTO contratoDTO) {
        Contrato contrato = contratoRepository.findById(contratoDTO.getContratoId()).orElseThrow(() -> new RuntimeException("Contrato no encontrado"));

        contrato.setEstado(contratoDTO.getEstado());

        LocalDate ultimoDiaMes = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
        contrato.setFechaPago(ultimoDiaMes.toString());

        return contratoRepository.save(contrato);
    }
}

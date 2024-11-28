package com.bancorealcash.app.BancoRealCash.service.Imp;

import com.bancorealcash.app.BancoRealCash.dto.SolicitudDTO;
import com.bancorealcash.app.BancoRealCash.entities.*;
import com.bancorealcash.app.BancoRealCash.repository.*;
import com.bancorealcash.app.BancoRealCash.service.SolicitudService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class SolicitudServiceImp implements SolicitudService {

    @Autowired
    private SolicitudRepository solicitudRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EstadoLaboralRepository estadoLaboralRepository;

    @Autowired
    private CuotaRepository cuotaRepository;

    @Autowired
    private HistorialCrediticioRepository historialCrediticioRepository;

    @Override
    public ResponseEntity<?> crearSolicitud(SolicitudDTO solicitud) {

        Solicitud nuevaSolicitud = new Solicitud();

        Usuario usuario = usuarioRepository.findById(solicitud.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        nuevaSolicitud.setUsuario(usuario);

        EstadoLaboral estadoLaboral = estadoLaboralRepository.findById(solicitud.getEstadoLaboralId())
                .orElseThrow(() -> new RuntimeException("Estado laboral no encontrado"));
        nuevaSolicitud.setEstadoLaboral(estadoLaboral);

        Cuota cuota = cuotaRepository.findById(solicitud.getCuotaId())
                .orElseThrow(() -> new RuntimeException("Cuota no encontrada"));
        nuevaSolicitud.setCuota(cuota);

        nuevaSolicitud.setNombreEmpresa(solicitud.getNombreEmpresa());
        nuevaSolicitud.setCargo(solicitud.getCargo());
        nuevaSolicitud.setIngresoMensual(solicitud.getInMensual());
        nuevaSolicitud.setMonto(solicitud.getMonto());

        try {
            solicitudRepository.save(nuevaSolicitud);
            return ResponseEntity.ok().body(Map.of("code", "000", "message", "Solicitud creada exitosamente"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("code", "999", "message", "Error al crear la solicitud", "details", e.getMessage()));
        }
    }

    @Override
    public List<Solicitud> listarSolicitudes() {
        return solicitudRepository.findAll();
    }

    @Override
    public void actualizarEstadoFinan(Integer solicitudId, String estadoFinan) {
        Solicitud solicitud = solicitudRepository.findById(solicitudId)
                .orElseThrow(() -> new RuntimeException("Solicitud no encontrada con ID: " + solicitudId));

        solicitud.setEstadoFinan(estadoFinan);
        solicitudRepository.save(solicitud);
    }

    @Override
    public void actualizarEstadoCredito(Integer solicitudId, String estadoCredito) {
        Solicitud solicitud = solicitudRepository.findById(solicitudId)
                .orElseThrow(() -> new RuntimeException("Solicitud no encontrada con ID: " + solicitudId));

        solicitud.setEstadoCredito(estadoCredito);
        solicitudRepository.save(solicitud);
    }

    @Override
    public void actualizarOficialCredito(Integer solicitudId, String oficialCredito) {
        Solicitud solicitud = solicitudRepository.findById(solicitudId)
                .orElseThrow(() -> new RuntimeException("Solicitud no encontrada con ID: " + solicitudId));

        solicitud.setEstadoFinal(oficialCredito);
        solicitudRepository.save(solicitud);
    }

    @Override
    public HistorialCrediticio obtenerOInsertarHistorial(Integer usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Optional<HistorialCrediticio> historialExistente = historialCrediticioRepository.findByUsuarioId(usuarioId);

        if (historialExistente.isPresent()) {
            return historialExistente.get();
        }

        HistorialCrediticio nuevoHistorial = new HistorialCrediticio();
        nuevoHistorial.setUsuario(usuario);
        nuevoHistorial.setRazon("No especifica");
        nuevoHistorial.setScore((int) (Math.random() * 1000) + 1);

        return historialCrediticioRepository.save(nuevoHistorial);
    }


}

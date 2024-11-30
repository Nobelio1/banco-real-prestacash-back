package com.bancorealcash.app.BancoRealCash.service.Imp;

import com.bancorealcash.app.BancoRealCash.dto.PrestamoDTO;
import com.bancorealcash.app.BancoRealCash.dto.PrestamoNDTO;
import com.bancorealcash.app.BancoRealCash.dto.SolicitudDTO;
import com.bancorealcash.app.BancoRealCash.entities.*;
import com.bancorealcash.app.BancoRealCash.repository.PrestamoRepository;
import com.bancorealcash.app.BancoRealCash.repository.SolicitudRepository;
import com.bancorealcash.app.BancoRealCash.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PrestamoServiceImp implements PrestamoService {

    @Autowired
    private PrestamoRepository prestamoRepository;

    @Autowired
    private SolicitudRepository solicitudRepository;

    public ResponseEntity<?> crearPrestamo(PrestamoNDTO prestamo) {

        Prestamo nuevoPrestamo = new Prestamo();

        Solicitud solicitud = solicitudRepository.findById(prestamo.getSolicitudId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        nuevoPrestamo.setSolicitud(solicitud);

        nuevoPrestamo.setCuotasPendientes(prestamo.getCuotasPendientes());
        nuevoPrestamo.setMora(prestamo.getMora());
        nuevoPrestamo.setEstado(prestamo.getEstado());

        try {
            prestamoRepository.save(nuevoPrestamo);
            return ResponseEntity.ok().body(Map.of("code", "000", "message", "Prestamo creada exitosamente"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("code", "999", "message", "Error al crear la solicitud", "details", e.getMessage()));
        }
    }

    public List<PrestamoDTO> obtenerTodosLosPrestamos() {
        List<Prestamo> prestamos = prestamoRepository.findAll();

        return prestamos.stream()
                .map(prestamo -> PrestamoDTO.builder()
                        .prestamoId(prestamo.getPrestamoId())
                        .solicitudId(prestamo.getSolicitud().getSolicitudId())
                        .cuotasPendientes(prestamo.getCuotasPendientes())
                        .mora(prestamo.getMora())
                        .estado(prestamo.getEstado())
                        .build())
                .collect(Collectors.toList());
    }

    public boolean actualizarMora(Integer prestamoId, Integer mora) {
        Optional<Prestamo> prestamoOptional = prestamoRepository.findById(prestamoId);

        if (prestamoOptional.isPresent()) {
            Prestamo prestamo = prestamoOptional.get();
            prestamo.setMora(mora);

            prestamoRepository.save(prestamo);
            return true;
        } else {
            return false;
        }
    }

    public boolean actualizarEstado(Integer prestamoId, String estado) {
        Optional<Prestamo> prestamoOptional = prestamoRepository.findById(prestamoId);

        if (prestamoOptional.isPresent()) {
            Prestamo prestamo = prestamoOptional.get();
            prestamo.setEstado(estado);

            prestamoRepository.save(prestamo);
            return true;
        } else {
            return false;
        }
    }
}

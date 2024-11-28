package com.bancorealcash.app.BancoRealCash.service.Imp;

import com.bancorealcash.app.BancoRealCash.dto.PrestamoDTO;
import com.bancorealcash.app.BancoRealCash.entities.Prestamo;
import com.bancorealcash.app.BancoRealCash.repository.PrestamoRepository;
import com.bancorealcash.app.BancoRealCash.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PrestamoServiceImp implements PrestamoService {

    @Autowired
    private PrestamoRepository prestamoRepository;

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

package com.bancorealcash.app.BancoRealCash.service.Imp;

import com.bancorealcash.app.BancoRealCash.dto.PagoRequestDTO;
import com.bancorealcash.app.BancoRealCash.dto.PagoResponseDTO;
import com.bancorealcash.app.BancoRealCash.entities.Pago;
import com.bancorealcash.app.BancoRealCash.entities.Prestamo;
import com.bancorealcash.app.BancoRealCash.repository.PagoRepository;
import com.bancorealcash.app.BancoRealCash.repository.PrestamoRepository;
import com.bancorealcash.app.BancoRealCash.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PagoServiceImp implements PagoService {

    @Autowired
    private PrestamoRepository prestamoRepository;

    @Autowired
    private PagoRepository pagoRepository;

    public boolean registrarPago(PagoRequestDTO pagoRequest) {
        Optional<Prestamo> prestamoOptional = prestamoRepository.findById(pagoRequest.getPrestamoId());

        if (prestamoOptional.isPresent()) {
            Prestamo prestamo = prestamoOptional.get();

            Pago nuevoPago = new Pago();
            nuevoPago.setPrestamo(prestamo);
            nuevoPago.setMonto(pagoRequest.getMonto());
            nuevoPago.setCuota(pagoRequest.getCuota());
            nuevoPago.setNroBoleta(pagoRequest.getNroBoleta());
            nuevoPago.setFechaPago(LocalDate.now().toString());

            pagoRepository.save(nuevoPago);

            return true;
        } else {
            return false;
        }
    }

    public List<PagoResponseDTO> obtenerPagosPorPrestamo(Integer prestamoId) {
        return pagoRepository.findByPrestamo_PrestamoId(prestamoId).stream().map( pago -> PagoResponseDTO.builder()
                .pagoId(pago.getPagoId())
                .prestamoId(pago.getPrestamo().getPrestamoId())
                .monto(pago.getMonto())
                .cuota(pago.getCuota())
                .nroBoleta(pago.getNroBoleta())
                .fechaPago(pago.getFechaPago())
                .build()).collect(Collectors.toList());
    }
}

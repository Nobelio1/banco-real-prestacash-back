package com.bancorealcash.app.BancoRealCash.repository;

import com.bancorealcash.app.BancoRealCash.entities.HistorialCrediticio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HistorialCrediticioRepository extends JpaRepository<HistorialCrediticio, Integer> {
    Optional<HistorialCrediticio> findByUsuarioId(Integer usuarioId);
}

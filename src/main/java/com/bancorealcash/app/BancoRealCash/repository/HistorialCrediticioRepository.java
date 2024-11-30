package com.bancorealcash.app.BancoRealCash.repository;

import com.bancorealcash.app.BancoRealCash.entities.HistorialCrediticio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HistorialCrediticioRepository extends JpaRepository<HistorialCrediticio, Integer> {
    Optional<HistorialCrediticio> findByUsuarioUsuarioId(Integer usuarioId);
}

package com.bancorealcash.app.BancoRealCash.repository;

import com.bancorealcash.app.BancoRealCash.entities.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContratoRepository extends JpaRepository<Contrato, Integer> {
    Optional<Contrato> findBySolicitudSolicitudId(Integer solicitudId);
}

package com.bancorealcash.app.BancoRealCash.repository;

import com.bancorealcash.app.BancoRealCash.entities.UsuarioInformacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioInformacionRepository extends JpaRepository<UsuarioInformacion, Long> {
    Optional<UsuarioInformacion> findByUsuarioId(Integer usuarioId);
}

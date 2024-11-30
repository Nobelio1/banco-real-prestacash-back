package com.bancorealcash.app.BancoRealCash.repository;

import com.bancorealcash.app.BancoRealCash.entities.Notificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificacionRepository extends JpaRepository<Notificacion, Integer> {
    List<Notificacion> findByUsuarioUsuarioId(Integer usuarioId);
}

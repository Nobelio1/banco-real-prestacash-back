package com.bancorealcash.app.BancoRealCash.service;

import com.bancorealcash.app.BancoRealCash.dto.NotificacionDTO;
import com.bancorealcash.app.BancoRealCash.dto.NotificacionResponseDTO;

import java.util.List;

public interface NotificacionService {

    public void crearNotificacion(NotificacionDTO notificacionDTO);
    public List<NotificacionResponseDTO> obtenerNotificacionesPorUsuarioId(Integer usuarioId);
}

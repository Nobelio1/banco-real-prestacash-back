package com.bancorealcash.app.BancoRealCash.service.Imp;

import com.bancorealcash.app.BancoRealCash.dto.NotificacionDTO;
import com.bancorealcash.app.BancoRealCash.dto.NotificacionResponseDTO;
import com.bancorealcash.app.BancoRealCash.entities.Notificacion;
import com.bancorealcash.app.BancoRealCash.entities.Usuario;
import com.bancorealcash.app.BancoRealCash.repository.NotificacionRepository;
import com.bancorealcash.app.BancoRealCash.repository.UsuarioRepository;
import com.bancorealcash.app.BancoRealCash.service.NotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificacionServiceImp implements NotificacionService {

    @Autowired
    private NotificacionRepository notificacionRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void crearNotificacion(NotificacionDTO notificacionDTO) {
        Usuario usuario = usuarioRepository.findById(notificacionDTO.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Notificacion nuevaNotificacion = new Notificacion();
        nuevaNotificacion.setUsuario(usuario);
        nuevaNotificacion.setTitulo(notificacionDTO.getTitulo());
        nuevaNotificacion.setDescripcion(notificacionDTO.getDescripcion());
        nuevaNotificacion.setFechaCreacion(LocalDateTime.now());

        notificacionRepository.save(nuevaNotificacion);
    }

    @Override
    public List<NotificacionResponseDTO> obtenerNotificacionesPorUsuarioId(Integer usuarioId) {
        List<Notificacion> notificaciones = notificacionRepository.findByUsuarioUsuarioId(usuarioId);

        if (notificaciones.isEmpty()) {
            throw new RuntimeException("No se encontraron notificaciones para el usuario con ID: " + usuarioId);
        }

        return notificaciones.stream()
                .map(notificacion -> NotificacionResponseDTO.builder()
                        .notificacionId(notificacion.getNotificacionId())
                        .titulo(notificacion.getTitulo())
                        .descripcion(notificacion.getDescripcion())
                        .fechaCreacion(notificacion.getFechaCreacion())
                        .build())
                .collect(Collectors.toList());
    }
}

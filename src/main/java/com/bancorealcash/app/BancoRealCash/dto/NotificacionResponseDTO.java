package com.bancorealcash.app.BancoRealCash.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class NotificacionResponseDTO {
    private Integer notificacionId;
    private String titulo;
    private String descripcion;
    private LocalDateTime fechaCreacion;
}

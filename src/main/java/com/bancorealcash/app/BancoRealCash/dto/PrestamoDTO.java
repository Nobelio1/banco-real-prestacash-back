package com.bancorealcash.app.BancoRealCash.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PrestamoDTO {
    private Integer prestamoId;
    private Integer solicitudId;
    private Integer usuarioId;
    private Integer cuotasPendientes;
    private Integer mora;
    private String estado;
}


package com.bancorealcash.app.BancoRealCash.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ContratoResponseDTO {
    private Integer contratoId;
    private Integer solicitudId;
    private String fechaPago;
    private String estado;
    private Date fechaCreacion;
}

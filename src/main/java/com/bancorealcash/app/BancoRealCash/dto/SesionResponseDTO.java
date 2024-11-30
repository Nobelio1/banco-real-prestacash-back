package com.bancorealcash.app.BancoRealCash.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SesionResponseDTO {
    private Integer usuarioId;
    private Integer rolId;
    private String rolNombre;
}

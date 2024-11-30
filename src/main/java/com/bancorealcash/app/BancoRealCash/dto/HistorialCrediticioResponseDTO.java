package com.bancorealcash.app.BancoRealCash.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HistorialCrediticioResponseDTO {
    private Integer hiscreId;
    private String usuarioId;
    private Integer score;
    private String razon;
}

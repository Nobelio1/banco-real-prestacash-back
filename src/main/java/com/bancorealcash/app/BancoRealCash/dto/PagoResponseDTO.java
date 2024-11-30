package com.bancorealcash.app.BancoRealCash.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PagoResponseDTO {
    private Integer pagoId;
    private Integer prestamoId;
    private Integer monto;
    private String cuota;
    private String nroBoleta;
    private String fechaPago;
}

package com.bancorealcash.app.BancoRealCash.dto;

import lombok.Data;

@Data
public class PagoRequestDTO {
    private Integer prestamoId;
    private Integer monto;
    private String cuota;
    private String nroBoleta;
}


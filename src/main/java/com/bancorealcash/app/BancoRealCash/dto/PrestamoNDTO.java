package com.bancorealcash.app.BancoRealCash.dto;

import lombok.Data;

@Data
public class PrestamoNDTO {
    private Integer solicitudId;
    private Integer cuotasPendientes;
    private Integer mora;
    private String estado;
}

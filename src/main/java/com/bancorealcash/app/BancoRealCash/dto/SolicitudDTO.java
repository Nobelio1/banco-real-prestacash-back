package com.bancorealcash.app.BancoRealCash.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SolicitudDTO {
    private Integer usuarioId;
    private Integer estadoLaboralId;
    private Integer cuotaId;
    private String nombreEmpresa;
    private String cargo;
    private Integer inMensual;
    private Integer monto;
}

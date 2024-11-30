package com.bancorealcash.app.BancoRealCash.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SolicitudResponseDTO {

    private Integer solicitudId;
    private Integer usuarioId;
    private Integer estadoLaboralId;
    private String estadoLaboral;
    private Integer cuotaId;
    private String cuota;
    private String nombreEmpresa;
    private String cargo;
    private Integer inMensual;
    private Integer monto;

    private String estadoFin;
    private String estadoCredito;
    private String estadoFinal;
}

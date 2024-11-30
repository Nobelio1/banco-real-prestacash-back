package com.bancorealcash.app.BancoRealCash.entities;


import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "solicitud")
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer solicitudId;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "estado_laboral_id", nullable = false)
    private EstadoLaboral estadoLaboral;

    @ManyToOne
    @JoinColumn(name = "cuota_id", nullable = false)
    private Cuota cuota;

    @Column(nullable = false, length = 100)
    private String nombreEmpresa;

    @Column(nullable = false, length = 100)
    private String cargo;

    @Column(name = "in_mensual", nullable = false)
    private Integer ingresoMensual;

    @Column(nullable = false)
    private Integer monto;

    @Column(length = 20)
    private String estadoFinan = "PENDIENTE";

    @Column(length = 20)
    private String estadoCredito = "PENDIENTE";

    @Column(length = 20)
    private String estadoUsuario = "PENDIENTE";

    @Column(length = 20)
    private String estadoFinal = "PENDIENTE";

    @Column(name = "fecha_creacion", nullable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fechaCreacion;
}

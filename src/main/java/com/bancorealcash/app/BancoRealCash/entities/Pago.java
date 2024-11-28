package com.bancorealcash.app.BancoRealCash.entities;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pago")
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pagoId;

    @ManyToOne
    @JoinColumn(name = "prestamo_id", nullable = false)
    private Prestamo prestamo;

    @Column(nullable = false)
    private Integer monto;

    @Column(length = 20)
    private String cuota;

    @Column(length = 100)
    private String nroBoleta;

    @Column(nullable = false, length = 20)
    private String fechaPago;

}

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
@Table(name = "estado_laboral")
public class EstadoLaboral {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer estadoLaboralId;

    @Column(nullable = false, length = 100)
    private String nombre;
}

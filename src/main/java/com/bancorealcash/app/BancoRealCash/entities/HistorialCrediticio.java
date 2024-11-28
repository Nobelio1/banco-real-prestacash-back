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
@Table(name = "historial_crediticio")
public class HistorialCrediticio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer hiscreId;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    private Integer score;

    @Column(length = 100)
    private String razon;
}

package com.BankCol.BankColApp.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "retiros")
public class Retiro {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, name = "codigo_retiro")
    private String codigoRetiro;

    @Column(nullable = false)
    private Date fecha;

    @Column(nullable = false)
    private Double monto;

    @ManyToOne
    @JoinColumn(name = "idcuenta_cliente", referencedColumnName = "id", nullable = false)
    private Cuenta cuentaId;
}

/*
    {
        "id": 2,
        "codigoRetiro": "678987567",
        "fecha": "2023-06-22T05:00:00.000+00:00",
        "monto": 300.5,
        "cuentaId": 2
    }
*/
package com.Bankcol.BankColApp.domain;

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
@Table(name = "consignaciones")
public class Consignacion {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Date fecha;

    @Column(nullable = false)
    private Double monto;

    @ManyToOne
    @JoinColumn(name = "idcuenta_cliente", referencedColumnName = "id", nullable = false)
    private Cliente cliente;
}

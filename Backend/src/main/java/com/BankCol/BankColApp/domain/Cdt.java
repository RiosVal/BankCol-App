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
@Table(name = "cdts")
public class Cdt {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer numero;

    @Column(nullable = false, name = "fecha_inicio")
    private Date fechaInicio;

    @Column(nullable = false, name = "fecha_fin")
    private Date fechaFin;

    @Column(nullable = false)
    private Double tasa;

    @Column(nullable = false, name = "monto_invertido")
    private Double montoInvertido;

    @Column(nullable = false, name = "monto_final")
    private Double montoFinal;

    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id", nullable = false)
    private Cliente clienteId;

    @ManyToOne
    @JoinColumn(name = "id_sucursal", referencedColumnName = "id", nullable = false)
    private Sucursal sucursal;

    @OneToOne
    @JoinColumn(name = "estado_cdt", referencedColumnName = "id", nullable = false)
    private EstadoCdt estadoCdt;

}
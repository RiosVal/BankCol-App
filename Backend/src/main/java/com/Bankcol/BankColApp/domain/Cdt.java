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
@Table(name = "cdts")
public class Cdt {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Date fecha_inicio;

    @Column(nullable = false)
    private Date fecha_fin;

    @Column(nullable = false)
    private Double tasa;

    @Column(nullable = false)
    private Double monto_invertido;

    @Column(nullable = false)
    private Double monto_final;

    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_sucursal", referencedColumnName = "id", nullable = false)
    private Sucursal sucursal;

    @OneToOne
    @JoinColumn(name = "estado_cdt", referencedColumnName = "id", nullable = false)
    private EstadoCdt estadoCdt;

}
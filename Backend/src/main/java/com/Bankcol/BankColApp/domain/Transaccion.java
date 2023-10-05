package com.Tecnicas.BancoApp.domain;

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
@Table(name = "transacciones")
public class Transaccion {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 30)
    private String tipo;

    @Column(nullable = false)
    private Date fecha;

    @Column(nullable = false)
    private Double monto;

    @Column(nullable = false, length = 50)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "idcuenta_cliente", referencedColumnName = "id", nullable = false)
    private Cuenta cuenta;

    @ManyToOne
    @JoinColumn(name = "idcuenta_destinatario", referencedColumnName = "id", nullable = false)
    private Destinatario destinatario;
}

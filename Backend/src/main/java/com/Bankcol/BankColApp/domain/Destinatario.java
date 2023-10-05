package com.Bankcol.BankColApp.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "destinatarios")
public class Destinatario {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer numcuenta_destinatario;

    @Column(nullable = false, length = 50)
    private String banco_destinatario;

    @Column(nullable = false)
    private Integer cedula_destinatario;

    @Column(nullable = false, length = 50)
    private String nombre_destinatario;

    @Column(nullable = false, length = 50)
    private String apellido_destinatario;

    @Column(nullable = false)
    private Boolean cuenta_favorita;
}
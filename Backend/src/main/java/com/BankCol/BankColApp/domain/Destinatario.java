package com.BankCol.BankColApp.domain;


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

    @Column(nullable = false, name = "numcuenta_destinatario")
    private Integer numcuentaDestinatario;

    @Column(nullable = false, length = 50, name = "banco_destinatario")
    private String bancoDestinatario;

    @Column(nullable = false, name = "cedula_destinatario")
    private Integer cedulaDestinatario;

    @Column(nullable = false, length = 50, name = "nombre_destinatario")
    private String nombreDestinatario;

    @Column(nullable = false, length = 50, name = "apellido_destinatario")
    private String apellidoDestinatario;

    @Column(nullable = false, name = "cuenta_favorita")
    private Boolean cuentaFavorita;
}

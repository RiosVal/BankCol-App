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
@Table(name = "cuentas")
public class Cuenta {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, name="numero_cuenta")
    private Integer numeroCuenta;

    @Column(nullable = false, name="monto_disponible")
    private Double montoDisponible;

    @OneToOne
    @JoinColumn(name = "tipo_cuenta", referencedColumnName = "id", nullable = false)
    private TipoCuenta tipoCuenta;

    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id", nullable = false)
    private Cliente clienteId;

    @ManyToOne
    @JoinColumn(name = "id_sucursal", referencedColumnName = "id", nullable = false)
    private Sucursal sucursalId;
}
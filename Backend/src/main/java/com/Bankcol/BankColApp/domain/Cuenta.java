package com.Tecnicas.BancoApp.domain;

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

    @Column(nullable = false)
    private Integer numero_cuenta;

    @Column(nullable = false)
    private Double monto_disponible;

    @OneToOne
    @JoinColumn(name = "tipo_cuenta", referencedColumnName = "id", nullable = false)
    private TipoCuenta tipoCuenta;

    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_sucursal", referencedColumnName = "id", nullable = false)
    private Sucursal sucursal;
}

package com.BankCol.BankColApp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CuentaDTO {
    private Integer id;
    private Integer numeroCuenta;
    private Double montoDisponible;
    private Integer tipoCuentaId;
    private Integer clienteId;
    private Integer sucursalId;
}
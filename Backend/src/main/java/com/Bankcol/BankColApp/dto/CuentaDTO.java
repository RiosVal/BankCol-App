package com.Tecnicas.BancoApp.dto;

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
    private Integer numero_cuenta;
    private Double monto_disponible;
    private Integer tipoCuentaId;
    private Integer clienteId;
    private Integer sucursalId;
}

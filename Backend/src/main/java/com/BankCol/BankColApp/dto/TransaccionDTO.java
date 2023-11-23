package com.BankCol.BankColApp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransaccionDTO {
    private Integer id;

    private String codigoTransaccion;

    private String tipo;

    private Date fecha;

    private Double monto;

    private String descripcion;

    private Integer cuentaId;

    private Integer destinatarioId;
}
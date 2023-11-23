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
public class CdtDTO {
    private Integer id;
    private Integer numero;
    private Date fechaInicio;
    private Date fechaFin;
    private Double tasa;
    private Double montoInvertido;
    private Double montoFinal;
    private Integer clienteId;
    private Integer sucursalId;
    private Integer estadoCdtId;
}

package com.Bankcol.BankColApp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RetiroDTO {
    private Integer id;

    private Date fecha;

    private Double monto;

    private Integer cuentaId;
}

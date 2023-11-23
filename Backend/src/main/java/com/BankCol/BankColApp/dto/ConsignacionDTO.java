package com.BankCol.BankColApp.dto;

import com.BankCol.BankColApp.domain.Cuenta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConsignacionDTO {
    private Integer id;
    private String codigoConsignacion;
    private Date fecha;
    private Double monto;
    private Integer cuentaId;
}

/*{
        "codigoConsignacion": "623918274",
        "fecha": "2023-11-20",
        "monto": 200,
        "cuentaId": 2
}*/
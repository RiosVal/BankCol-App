package com.Tecnicas.BancoApp.dto;

import com.Tecnicas.BancoApp.domain.Cliente;
import com.Tecnicas.BancoApp.domain.EstadoCdt;
import com.Tecnicas.BancoApp.domain.Sucursal;
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
    private Date fecha_inicio;
    private Date fecha_fin;
    private Double tasa;
    private Double monto_invertido;
    private Double monto_final;
    private Integer clienteId;
    private Integer sucursalId;
    private Integer estadoCdtId;
}

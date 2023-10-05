package com.Tecnicas.BancoApp.dto;

import com.Tecnicas.BancoApp.domain.Cliente;
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
    private Date fecha;
    private Double monto;
    private Integer clienteId;
}

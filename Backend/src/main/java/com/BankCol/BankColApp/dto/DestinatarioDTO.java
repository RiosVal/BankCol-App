package com.BankCol.BankColApp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DestinatarioDTO {
    private Integer id;
    private Integer numcuentaDestinatario;
    private String bancoDestinatario;

    private Integer cedulaDestinatario;

    private String nombreDestinatario;

    private String apellidoDestinatario;

    private Boolean cuentaFavorita;
}
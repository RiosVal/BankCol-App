package com.Tecnicas.BancoApp.dto;

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
    private Integer numcuenta_destinatario;
    private String banco_destinatario;

    private Integer cedula_destinatario;

    private String nombre_destinatario;

    private String apellido_destinatario;

    private Boolean cuenta_favorita;
}

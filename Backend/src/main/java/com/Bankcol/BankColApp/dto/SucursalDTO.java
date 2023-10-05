package com.Tecnicas.BancoApp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SucursalDTO {
    private Integer id;
    private String ciudad;
    private String direccion;
    private String telefono;
}

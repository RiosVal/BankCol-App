package com.Bankcol.BankColApp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {
    private Integer id;
    private Integer cedula;
    private String nombre;
    private String apellido;
    private String usuario;
    private String correo;
    private String contra;
}
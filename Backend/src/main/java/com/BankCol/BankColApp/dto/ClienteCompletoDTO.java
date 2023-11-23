package com.BankCol.BankColApp.dto;

import java.util.List;

public class ClienteCompletoDTO {
    private Integer id;
    private Integer cedula;
    private String nombre;
    private String apellido;
    private String usuario;
    private String correo;
    private String contra;
    private List<CdtDTO> cdts;
    private List<CuentaDTO> cuentas;
}

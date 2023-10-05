package com.Tecnicas.BancoApp.mapper;

import com.Tecnicas.BancoApp.domain.Cuenta;
import com.Tecnicas.BancoApp.dto.CuentaDTO;

import java.util.List;
/*-----------------------------------------------FALTAN LAS FOREIGN KEYS-----------------------------------------------*/
public class CuentaMapper {
    public static Cuenta dtoToDomain(CuentaDTO cuentaDTO) {
        return Cuenta.builder()
                .id(cuentaDTO.getId())
                .numero_cuenta(cuentaDTO.getNumero_cuenta())
                .monto_disponible(cuentaDTO.getMonto_disponible())
                .build();
    }

    public static CuentaDTO domainToDto(Cuenta cuenta) {
        return CuentaDTO.builder()
                .id(cuenta.getId())
                .numero_cuenta(cuenta.getNumero_cuenta())
                .monto_disponible(cuenta.getMonto_disponible())
                .build();
    }
    public static List<Cuenta> dtoToDomainList(List<CuentaDTO> cuentaDTOS) {
        return cuentaDTOS.stream().map(CuentaMapper::dtoToDomain).toList();
    }

    public static  List<CuentaDTO> domainToDtoList(List<Cuenta> cuentas) {
        return cuentas.stream().map(CuentaMapper::domainToDto).toList();
    }
}

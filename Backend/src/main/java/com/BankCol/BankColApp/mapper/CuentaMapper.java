package com.BankCol.BankColApp.mapper;

import com.BankCol.BankColApp.domain.Consignacion;
import com.BankCol.BankColApp.domain.Cuenta;
import com.BankCol.BankColApp.dto.ConsignacionDTO;
import com.BankCol.BankColApp.dto.CuentaDTO;

import java.util.List;

public class CuentaMapper {
    public static Cuenta dtoToDomain(CuentaDTO cuentaDTO){
        return Cuenta.builder()
                .id(cuentaDTO.getId())
                .numeroCuenta(cuentaDTO.getNumeroCuenta())
                .montoDisponible(cuentaDTO.getMontoDisponible())
                .build();
    }

    public static CuentaDTO domainToDto(Cuenta cuenta){
        return CuentaDTO.builder()
                .id(cuenta.getId())
                .numeroCuenta(cuenta.getNumeroCuenta())
                .montoDisponible(cuenta.getMontoDisponible())
                .tipoCuentaId((cuenta.getTipoCuenta() == null) ?
                        null : cuenta.getTipoCuenta().getId())
                .clienteId((cuenta.getClienteId() == null) ?
                        null : cuenta.getClienteId().getId())
                .sucursalId((cuenta.getSucursalId() == null) ?
                        null : cuenta.getSucursalId().getId())
                .build();
    }

    public static List<Cuenta> dtoToDomainList(List<CuentaDTO> cuentaDTOS) {
        return cuentaDTOS.stream().map(CuentaMapper::dtoToDomain).toList();
    }

    public static  List<CuentaDTO> domainToDtoList(List<Cuenta> cuentas) {
        return cuentas.stream().map(CuentaMapper::domainToDto).toList();
    }
}

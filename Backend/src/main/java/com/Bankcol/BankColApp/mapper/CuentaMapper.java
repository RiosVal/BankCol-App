package com.Bankcol.BankColApp.mapper;

import com.Bankcol.BankColApp.domain.Cuenta;
import com.Bankcol.BankColApp.dto.CuentaDTO;

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
                .tipoCuentaId((cuenta.getTipoCuenta() == null) ?
                        null : cuenta.getTipoCuenta().getId())
                .clienteId((cuenta.getCliente() == null) ?
                        null : cuenta.getCliente().getId())
                .sucursalId((cuenta.getSucursal() == null) ?
                        null : cuenta.getSucursal().getId())
                .build();
    }
    public static List<Cuenta> dtoToDomainList(List<CuentaDTO> cuentaDTOS) {
        return cuentaDTOS.stream().map(CuentaMapper::dtoToDomain).toList();
    }

    public static  List<CuentaDTO> domainToDtoList(List<Cuenta> cuentas) {
        return cuentas.stream().map(CuentaMapper::domainToDto).toList();
    }
}

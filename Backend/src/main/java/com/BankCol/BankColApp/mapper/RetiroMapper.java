package com.BankCol.BankColApp.mapper;

import com.BankCol.BankColApp.domain.Retiro;
import com.BankCol.BankColApp.dto.RetiroDTO;

import java.util.List;

public class RetiroMapper {
    public static Retiro dtoToDomain(RetiroDTO retiroDTO) {
        return Retiro.builder()
                .id(retiroDTO.getId())
                .codigoRetiro(retiroDTO.getCodigoRetiro())
                .fecha(retiroDTO.getFecha())
                .monto(retiroDTO.getMonto())
                .build();
    }

    public static RetiroDTO domainToDto(Retiro retiro) {
        return RetiroDTO.builder()
                .id(retiro.getId())
                .codigoRetiro(retiro.getCodigoRetiro())
                .fecha(retiro.getFecha())
                .monto(retiro.getMonto())
                .cuentaId((retiro.getCuentaId() == null) ?
                        null : retiro.getCuentaId().getId())
                .build();
    }

    public static List<Retiro> dtoToDomainList(List<RetiroDTO> retiroDTOS) {
        return retiroDTOS.stream().map(RetiroMapper::dtoToDomain).toList();
    }

    public static  List<RetiroDTO> domainToDtoList(List<Retiro> retiros) {
        return retiros.stream().map(RetiroMapper::domainToDto).toList();
    }
}

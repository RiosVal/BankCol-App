package com.BankCol.BankColApp.mapper;

import com.BankCol.BankColApp.domain.Consignacion;
import com.BankCol.BankColApp.dto.ConsignacionDTO;

import java.util.List;

public class ConsignacionMapper {
    public static Consignacion dtoToDomain(ConsignacionDTO consignacionDTO) {
        return Consignacion.builder()
                .id(consignacionDTO.getId())
                .codigoConsignacion(consignacionDTO.getCodigoConsignacion())
                .fecha(consignacionDTO.getFecha())
                .monto(consignacionDTO.getMonto())
                .build();
    }

    public static ConsignacionDTO domainToDto(Consignacion consignacion) {
        return ConsignacionDTO.builder()
                .id(consignacion.getId())
                .codigoConsignacion(consignacion.getCodigoConsignacion())
                .fecha(consignacion.getFecha())
                .monto(consignacion.getMonto())
                .cuentaId((consignacion.getCuentaId() == null) ?
                        null : consignacion.getCuentaId().getId())
                .build();
    }
    public static List<Consignacion> dtoToDomainList(List<ConsignacionDTO> consignacionDTOS) {
        return consignacionDTOS.stream().map(ConsignacionMapper::dtoToDomain).toList();
    }

    public static  List<ConsignacionDTO> domainToDtoList(List<Consignacion> consignacions) {
        return consignacions.stream().map(ConsignacionMapper::domainToDto).toList();
    }
}

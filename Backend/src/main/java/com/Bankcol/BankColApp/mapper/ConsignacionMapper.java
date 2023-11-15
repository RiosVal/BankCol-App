package com.Bankcol.BankColApp.mapper;

import com.Bankcol.BankColApp.domain.Consignacion;
import com.Bankcol.BankColApp.dto.ConsignacionDTO;

import java.util.List;
/*-----------------------------------------------FALTA LA FOREIGN KEY-----------------------------------------------*/
public class ConsignacionMapper {
    public static Consignacion dtoToDomain(ConsignacionDTO consignacionDTO) {
        return Consignacion.builder()
                .id(consignacionDTO.getId())
                .fecha(consignacionDTO.getFecha())
                .monto(consignacionDTO.getMonto())
                .build();
    }

    public static ConsignacionDTO domainToDto(Consignacion consignacion) {
        return ConsignacionDTO.builder()
                .id(consignacion.getId())
                .fecha(consignacion.getFecha())
                .monto(consignacion.getMonto())
                .clienteId((consignacion.getCliente() == null) ?
                        null : consignacion.getCliente().getId())
                .build();
    }
    public static List<Consignacion> dtoToDomainList(List<ConsignacionDTO> consignacionDTOS) {
        return consignacionDTOS.stream().map(ConsignacionMapper::dtoToDomain).toList();
    }

    public static  List<ConsignacionDTO> domainToDtoList(List<Consignacion> consignacions) {
        return consignacions.stream().map(ConsignacionMapper::domainToDto).toList();
    }
}


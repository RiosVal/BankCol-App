package com.Tecnicas.BancoApp.mapper;

import com.Tecnicas.BancoApp.domain.Consignacion;
import com.Tecnicas.BancoApp.dto.ConsignacionDTO;

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
                .build();
    }
    public static List<Consignacion> dtoToDomainList(List<ConsignacionDTO> consignacionDTOS) {
        return consignacionDTOS.stream().map(ConsignacionMapper::dtoToDomain).toList();
    }

    public static  List<ConsignacionDTO> domainToDtoList(List<Consignacion> consignacions) {
        return consignacions.stream().map(ConsignacionMapper::domainToDto).toList();
    }
}

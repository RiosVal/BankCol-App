package com.Bankcol.BankColApp.mapper;

import com.Bankcol.BankColApp.domain.EstadoCdt;
import com.Bankcol.BankColApp.dto.EstadoCdtDTO;

import java.util.List;

public class EstadoCdtMapper {
    public static EstadoCdt dtoToDomain(EstadoCdtDTO estadoCdtDTO) {
        return EstadoCdt.builder()
                .id(estadoCdtDTO.getId())
                .descripcion(estadoCdtDTO.getDescripcion())
                .build();
    }

    public static EstadoCdtDTO domainToDto(EstadoCdt estadoCdt) {
        return EstadoCdtDTO.builder()
                .id(estadoCdt.getId())
                .descripcion(estadoCdt.getDescripcion())
                .build();
    }

    public static List<EstadoCdt> dtoToDomainList(List<EstadoCdtDTO> estadoCdtDTOS) {
        return estadoCdtDTOS.stream().map(EstadoCdtMapper::dtoToDomain).toList();
    }

    public static  List<EstadoCdtDTO> domainToDtoList(List<EstadoCdt> estadoCdts) {
        return estadoCdts.stream().map(EstadoCdtMapper::domainToDto).toList();
    }
}
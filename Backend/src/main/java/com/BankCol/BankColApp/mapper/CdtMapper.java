package com.BankCol.BankColApp.mapper;

import com.BankCol.BankColApp.domain.Cdt;
import com.BankCol.BankColApp.dto.CdtDTO;

import java.util.List;

public class CdtMapper {
    public static Cdt dtoToDomain(CdtDTO cdtDTO) {
        return Cdt.builder()
                .id(cdtDTO.getId())
                .numero(cdtDTO.getNumero())
                .fechaInicio(cdtDTO.getFechaInicio())
                .fechaFin(cdtDTO.getFechaFin())
                .tasa(cdtDTO.getTasa())
                .montoInvertido(cdtDTO.getMontoInvertido())
                .montoFinal(cdtDTO.getMontoFinal())
                .build();
    }

    public static CdtDTO domainToDto(Cdt cdt) {
        return CdtDTO.builder()
                .id(cdt.getId())
                .numero(cdt.getNumero())
                .fechaInicio(cdt.getFechaInicio())
                .fechaFin(cdt.getFechaFin())
                .tasa(cdt.getTasa())
                .montoInvertido(cdt.getMontoInvertido())
                .montoFinal(cdt.getMontoFinal())
                .clienteId((cdt.getClienteId() == null) ?
                        null : cdt.getClienteId().getId())
                .sucursalId((cdt.getSucursal() == null) ?
                        null : cdt.getSucursal().getId())
                .estadoCdtId((cdt.getSucursal() == null) ?
                        null : cdt.getEstadoCdt().getId())
                .build();
    }
    public static List<Cdt> dtoToDomainList(List<CdtDTO> cdtDTOS) {
        return cdtDTOS.stream().map(CdtMapper::dtoToDomain).toList();
    }

    public static  List<CdtDTO> domainToDtoList(List<Cdt> cdts) {
        return cdts.stream().map(CdtMapper::domainToDto).toList();
    }
}

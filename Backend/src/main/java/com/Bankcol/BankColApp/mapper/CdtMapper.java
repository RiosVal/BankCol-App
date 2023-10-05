package com.Bankcol.BankColApp.mapper;

import com.Bankcol.BankColApp.domain.Cdt;
import com.Bankcol.BankColApp.dto.CdtDTO;

import java.util.List;
/*-----------------------------------------------FALTAN LAS FOREIGN KEYS-----------------------------------------------*/
public class CdtMapper {
    public static Cdt dtoToDomain(CdtDTO cdtDTO) {
        return Cdt.builder()
                .id(cdtDTO.getId())
                .fecha_inicio(cdtDTO.getFecha_inicio())
                .fecha_fin(cdtDTO.getFecha_fin())
                .tasa(cdtDTO.getTasa())
                .monto_invertido(cdtDTO.getMonto_invertido())
                .monto_final(cdtDTO.getMonto_final())
                .build();
    }

    public static CdtDTO domainToDto(Cdt cdt) {
        return CdtDTO.builder()
                .id(cdt.getId())
                .fecha_inicio(cdt.getFecha_inicio())
                .fecha_fin(cdt.getFecha_fin())
                .tasa(cdt.getTasa())
                .monto_invertido(cdt.getMonto_invertido())
                .monto_final(cdt.getMonto_final())
                .build();
    }
    public static List<Cdt> dtoToDomainList(List<CdtDTO> cdtDTOS) {
        return cdtDTOS.stream().map(CdtMapper::dtoToDomain).toList();
    }

    public static  List<CdtDTO> domainToDtoList(List<Cdt> cdts) {
        return cdts.stream().map(CdtMapper::domainToDto).toList();
    }
}
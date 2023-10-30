package com.Bankcol.BankColApp.mapper;

import com.Bankcol.BankColApp.domain.Retiro;
import com.Bankcol.BankColApp.dto.RetiroDTO;

import java.util.List;
/*-----------------------------------------------FALTA LA FOREIGN KEY-----------------------------------------------*/
public class RetiroMapper {
    public static Retiro dtoToDomain(RetiroDTO retiroDTO) {
        return Retiro.builder()
                .id(retiroDTO.getId())
                .fecha(retiroDTO.getFecha())
                .monto(retiroDTO.getMonto())
                .build();
    }

    public static RetiroDTO domainToDto(Retiro retiro) {
        return RetiroDTO.builder()
                .id(retiro.getId())
                .fecha(retiro.getFecha())
                .monto(retiro.getMonto())
                .build();
    }
    public static List<Retiro> dtoToDomainList(List<RetiroDTO> retiroDTOS) {
        return retiroDTOS.stream().map(RetiroMapper::dtoToDomain).toList();
    }

    public static  List<RetiroDTO> domainToDtoList(List<Retiro> retiros) {
        return retiros.stream().map(RetiroMapper::domainToDto).toList();
    }
}

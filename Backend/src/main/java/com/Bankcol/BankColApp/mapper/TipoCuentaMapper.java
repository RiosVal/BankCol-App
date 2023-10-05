package com.Tecnicas.BancoApp.mapper;

import com.Tecnicas.BancoApp.domain.TipoCuenta;
import com.Tecnicas.BancoApp.dto.TipoCuentaDTO;

import java.util.List;

public class TipoCuentaMapper {

    public static TipoCuenta dtoToDomain(TipoCuentaDTO tipoCuentaDTO) {
        return TipoCuenta.builder()
                .id(tipoCuentaDTO.getId())
                .descripcion(tipoCuentaDTO.getDescripcion())
                .build();
    }

    public static TipoCuentaDTO domainToDto(TipoCuenta tipoCuenta) {
        return TipoCuentaDTO.builder()
                .id(tipoCuenta.getId())
                .descripcion(tipoCuenta.getDescripcion())
                .build();
    }

    public static List<TipoCuenta> dtoToDomainList(List<TipoCuentaDTO> tipoCuentaDTOS) {
        return tipoCuentaDTOS.stream().map(TipoCuentaMapper::dtoToDomain).toList();
    }

    public static  List<TipoCuentaDTO> domainToDtoList(List<TipoCuenta> tipoCuentas) {
        return tipoCuentas.stream().map(TipoCuentaMapper::domainToDto).toList();
    }
}

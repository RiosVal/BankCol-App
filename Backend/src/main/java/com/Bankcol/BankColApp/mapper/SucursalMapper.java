package com.Tecnicas.BancoApp.mapper;

import com.Tecnicas.BancoApp.domain.Sucursal;
import com.Tecnicas.BancoApp.dto.SucursalDTO;

import java.util.List;

public class SucursalMapper {

    public static Sucursal dtoToDomain(SucursalDTO sucursalDTO) {
        return Sucursal.builder()
                .id(sucursalDTO.getId())
                .ciudad(sucursalDTO.getCiudad())
                .direccion(sucursalDTO.getDireccion())
                .telefono(sucursalDTO.getTelefono())
                .build();
    }

    public static SucursalDTO domainToDto(Sucursal sucursal) {
        return SucursalDTO.builder()
                .id(sucursal.getId())
                .ciudad(sucursal.getCiudad())
                .direccion(sucursal.getDireccion())
                .telefono(sucursal.getTelefono())
                .build();
    }
    public static List<Sucursal> dtoToDomainList(List<SucursalDTO> sucursalDTOS) {
        return sucursalDTOS.stream().map(SucursalMapper::dtoToDomain).toList();
    }

    public static  List<SucursalDTO> domainToDtoList(List<Sucursal> sucursals) {
        return sucursals.stream().map(SucursalMapper::domainToDto).toList();
    }
}

package com.Tecnicas.BancoApp.mapper;
import com.Tecnicas.BancoApp.domain.Destinatario;
import com.Tecnicas.BancoApp.dto.DestinatarioDTO;

import java.util.List;

public class DestinatarioMapper {
    public static Destinatario dtoToDomain(DestinatarioDTO destinatarioDTO) {
        return Destinatario.builder()
                .id(destinatarioDTO.getId())
                .numcuenta_destinatario(destinatarioDTO.getNumcuenta_destinatario())
                .banco_destinatario(destinatarioDTO.getBanco_destinatario())
                .cedula_destinatario(destinatarioDTO.getCedula_destinatario())
                .nombre_destinatario(destinatarioDTO.getNombre_destinatario())
                .cuenta_favorita(destinatarioDTO.getCuenta_favorita())
                .build();
    }

    public static DestinatarioDTO domainToDto(Destinatario destinatario) {
        return DestinatarioDTO.builder()
                .id(destinatario.getId())
                .numcuenta_destinatario(destinatario.getNumcuenta_destinatario())
                .banco_destinatario(destinatario.getBanco_destinatario())
                .cedula_destinatario(destinatario.getCedula_destinatario())
                .nombre_destinatario(destinatario.getNombre_destinatario())
                .apellido_destinatario(destinatario.getApellido_destinatario())
                .cuenta_favorita(destinatario.getCuenta_favorita())
                .build();
    }
    public static List<Destinatario> dtoToDomainList(List<DestinatarioDTO> destinatarioDTOS) {
        return destinatarioDTOS.stream().map(DestinatarioMapper::dtoToDomain).toList();
    }

    public static  List<DestinatarioDTO> domainToDtoList(List<Destinatario> destinatarios) {
        return destinatarios.stream().map(DestinatarioMapper::domainToDto).toList();
    }
}

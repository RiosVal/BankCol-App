package com.BankCol.BankColApp.mapper;

import com.BankCol.BankColApp.domain.Destinatario;
import com.BankCol.BankColApp.dto.DestinatarioDTO;

import java.util.List;

public class DestinatarioMapper {
    public static Destinatario dtoToDomain(DestinatarioDTO destinatarioDTO) {
        return Destinatario.builder()
                .id(destinatarioDTO.getId())
                .numcuentaDestinatario(destinatarioDTO.getNumcuentaDestinatario())
                .bancoDestinatario(destinatarioDTO.getBancoDestinatario())
                .cedulaDestinatario(destinatarioDTO.getCedulaDestinatario())
                .nombreDestinatario(destinatarioDTO.getNombreDestinatario())
                .apellidoDestinatario(destinatarioDTO.getApellidoDestinatario())
                .cuentaFavorita(destinatarioDTO.getCuentaFavorita())
                .build();
    }

    public static DestinatarioDTO domainToDto(Destinatario destinatario) {
        return DestinatarioDTO.builder()
                .id(destinatario.getId())
                .numcuentaDestinatario(destinatario.getNumcuentaDestinatario())
                .bancoDestinatario(destinatario.getBancoDestinatario())
                .cedulaDestinatario(destinatario.getCedulaDestinatario())
                .nombreDestinatario(destinatario.getNombreDestinatario())
                .apellidoDestinatario(destinatario.getApellidoDestinatario())
                .cuentaFavorita(destinatario.getCuentaFavorita())
                .build();
    }
    public static List<Destinatario> dtoToDomainList(List<DestinatarioDTO> destinatarioDTOS) {
        return destinatarioDTOS.stream().map(DestinatarioMapper::dtoToDomain).toList();
    }

    public static  List<DestinatarioDTO> domainToDtoList(List<Destinatario> destinatarios) {
        return destinatarios.stream().map(DestinatarioMapper::domainToDto).toList();
    }
}
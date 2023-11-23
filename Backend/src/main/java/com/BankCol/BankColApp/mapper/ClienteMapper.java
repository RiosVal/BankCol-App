package com.BankCol.BankColApp.mapper;

import com.BankCol.BankColApp.domain.Cliente;
import com.BankCol.BankColApp.dto.ClienteDTO;

import java.util.List;

public class ClienteMapper {

    public static Cliente dtoToDomain(ClienteDTO clienteDTO) {
        return Cliente.builder()
                .id(clienteDTO.getId())
                .cedula(clienteDTO.getCedula())
                .nombre(clienteDTO.getNombre())
                .apellido(clienteDTO.getApellido())
                .usuario(clienteDTO.getUsuario())
                .correo(clienteDTO.getCorreo())
                .contra(clienteDTO.getContra())
                .build();
    }

    public static ClienteDTO domainToDto(Cliente cliente) {
        return ClienteDTO.builder()
                .id(cliente.getId())
                .cedula(cliente.getCedula())
                .nombre(cliente.getNombre())
                .apellido(cliente.getApellido())
                .usuario(cliente.getUsuario())
                .correo(cliente.getCorreo())
                .contra(cliente.getContra())
                .build();
    }

    public static List<Cliente> dtoToDomainList(List<ClienteDTO> clienteDTOS) {
        return clienteDTOS.stream().map(ClienteMapper::dtoToDomain).toList();
    }

    public static  List<ClienteDTO> domainToDtoList(List<Cliente> clientes) {
        return clientes.stream().map(ClienteMapper::domainToDto).toList();
    }
}

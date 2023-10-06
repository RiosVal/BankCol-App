package com.Bankcol.BankColApp.service.impl;

import com.Bankcol.BankColApp.domain.Cliente;
import com.Bankcol.BankColApp.dto.ClienteDTO;
import com.Bankcol.BankColApp.mapper.ClienteMapper;
import com.Bankcol.BankColApp.repository.ClienteRepository;
import com.Bankcol.BankColApp.service.ClienteService;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public ClienteDTO guardarNuevoCliente(ClienteDTO clienteDTO) throws Exception {
        if (clienteDTO == null) {
            throw new Exception("El cliente es nulo");
        }

        if (clienteDTO.getCedula() == null) {
            throw new Exception("Cédula vacía");
        }

        if (clienteDTO.getNombre() == null || clienteDTO.getNombre().trim().isEmpty()) {
            throw new Exception("Nombre vacío");
        }

        if (clienteDTO.getApellido() == null || clienteDTO.getApellido().trim().isEmpty()){
            throw new Exception("Apellido vacío");
        }

        if (clienteDTO.getUsuario() == null || clienteDTO.getUsuario().trim().isEmpty()){
            throw new Exception("Usuario vacío");
        }

        if (clienteDTO.getCorreo() == null || clienteDTO.getCorreo().trim().isEmpty()) {
            throw new Exception("Correo vacío");
        }

        if (clienteDTO.getContra() == null || clienteDTO.getContra().trim().isEmpty()) {
            throw new Exception("Contraseñan vacía");
        }

        Cliente cliente = ClienteMapper.dtoToDomain(clienteDTO);
        cliente = clienteRepository.save(cliente);
        clienteDTO = ClienteMapper.domainToDto(cliente);


        return clienteDTO;
    }
}

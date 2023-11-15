package com.Bankcol.BankColApp.service.impl;

import com.Bankcol.BankColApp.domain.Cliente;
import com.Bankcol.BankColApp.dto.CdtDTO;
import com.Bankcol.BankColApp.dto.ClienteDTO;
import com.Bankcol.BankColApp.mapper.CdtMapper;
import com.Bankcol.BankColApp.mapper.ClienteMapper;
import com.Bankcol.BankColApp.repository.ClienteRepository;
import com.Bankcol.BankColApp.service.ClienteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

        //Validar que el cliente no exista por la cedula
        Optional<Cliente> clientePorCedula = clienteRepository.findByCedula(clienteDTO.getCedula());
        if (clientePorCedula.isEmpty()) {
            throw new Exception("Ya existe un cliente con la cédula " + clienteDTO.getCedula());
        }
        //Validar que el cliente no exista por el correo
        Optional<Cliente> clientePorCorreo = clienteRepository.findByCorreo(clienteDTO.getCorreo());
        if (clientePorCorreo.isEmpty()) {
            throw new Exception("Ya existe un cliente con el correo " + clienteDTO.getCorreo());
        }
        //Validar que el cliente no exista por el usuario
        Optional<Cliente> clientePorUsuario = clienteRepository.findByUsuario(clienteDTO.getUsuario());
        if (clientePorUsuario.isEmpty()) {
            throw new Exception("Ya existe un cliente con el usuario " + clienteDTO.getUsuario());
        }

        Cliente cliente = ClienteMapper.dtoToDomain(clienteDTO);
        cliente = clienteRepository.save(cliente);

        return ClienteMapper.domainToDto(cliente);
    }

    @Override
    public List<CdtDTO> buscarTodos() {
        return null;
    }

}

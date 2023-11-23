package com.BankCol.BankColApp.service.impl;


import com.BankCol.BankColApp.domain.Cliente;
import com.BankCol.BankColApp.dto.ClienteCompletoDTO;
import com.BankCol.BankColApp.dto.ClienteDTO;
import com.BankCol.BankColApp.mapper.ClienteMapper;
import com.BankCol.BankColApp.repository.ClienteRepository;
import com.BankCol.BankColApp.service.ClienteService;
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
        //Validar los datos del cliente
        if(clienteDTO == null) { throw new Exception("El cliente es nulo"); }

        if(clienteDTO.getCedula() == null) { throw new Exception("La cedula en vacía"); }

        if (clienteDTO.getNombre() == null || clienteDTO.getNombre().isEmpty()) { throw new Exception("El nombre es vacío"); }

        if (clienteDTO.getApellido()== null || clienteDTO.getApellido().isEmpty()) { throw new Exception("El apellido es vacío"); }

        if (clienteDTO.getUsuario() == null || clienteDTO.getUsuario().isEmpty()) { throw new Exception("El usuario es vacío"); }

        if (clienteDTO.getCorreo() == null || clienteDTO.getCorreo().isEmpty()) { throw new Exception("El correo es vacío"); }

        if (clienteDTO.getContra() == null || clienteDTO.getContra().isEmpty()) { throw new Exception("La contraseña es vacía"); }

        //Validar que no exista un cliente con esa cedula
        Optional<Cliente> clientePorCedula = clienteRepository.findClienteByCedula(clienteDTO.getCedula());

        if (clientePorCedula.isPresent()){
            throw new Exception("El cliente con cédula "+ clienteDTO.getCedula() +" ya se encuentra registrado");
        }

        //Registrar el cliente en DB
        Cliente cliente = ClienteMapper.dtoToDomain(clienteDTO);
        cliente = clienteRepository.save(cliente);

        //Retornar el cliente mapeado en DTO
        clienteDTO = ClienteMapper.domainToDto(cliente);

        return clienteDTO;  //minuto 7:33 video 13
    }

    @Override
    public List<ClienteDTO> buscarTodos() {
        return ClienteMapper.domainToDtoList(clienteRepository.findAll());
    }

    @Override
    public ClienteDTO buscarPorCedula(Integer cedula) throws Exception {
        if(cedula == null){
            throw new Exception("Cdédula no válida");
        }
        return ClienteMapper.domainToDto(clienteRepository.findByCedula(cedula));
    }

    @Override
    public ClienteDTO buscarPorUsuario(String usuario) throws Exception {
        if(usuario == null){
            throw new Exception("Usuario no válido");
        }
        return ClienteMapper.domainToDto(clienteRepository.findByUsuario(usuario));
    }

    @Override
    public ClienteDTO buscarPorId(Integer id) throws Exception {
        if(id == null || id.equals(0)){
            throw new Exception("Id no valido");
        }

        return ClienteMapper.domainToDto(clienteRepository.getReferenceById(id));
    }

}

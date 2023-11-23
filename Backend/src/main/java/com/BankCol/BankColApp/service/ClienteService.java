package com.BankCol.BankColApp.service;

import com.BankCol.BankColApp.domain.Cliente;
import com.BankCol.BankColApp.dto.ClienteDTO;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    public ClienteDTO guardarNuevoCliente(ClienteDTO clienteDTO) throws Exception;

    List<ClienteDTO> buscarTodos();

    ClienteDTO buscarPorCedula(Integer cedula) throws Exception;

    ClienteDTO buscarPorUsuario(String usuario) throws Exception;

    ClienteDTO buscarPorId(Integer id) throws Exception;
}

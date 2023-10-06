package com.Bankcol.BankColApp.service;

import com.Bankcol.BankColApp.dto.ClienteDTO;

public interface ClienteService {
    public ClienteDTO guardarNuevoCliente(ClienteDTO clienteDTO) throws Exception;
}

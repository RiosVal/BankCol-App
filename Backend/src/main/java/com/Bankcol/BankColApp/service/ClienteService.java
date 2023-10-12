package com.Bankcol.BankColApp.service;

import com.Bankcol.BankColApp.dto.ClienteDTO;

public interface ClienteService {
    ClienteDTO guardarNuevoCliente(ClienteDTO clienteDTO) throws Exception;
}

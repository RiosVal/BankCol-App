package com.Bankcol.BankColApp.service;

import com.Bankcol.BankColApp.dto.CdtDTO;
import com.Bankcol.BankColApp.dto.ClienteDTO;

import java.util.List;

public interface ClienteService {
    ClienteDTO guardarNuevoCliente(ClienteDTO clienteDTO) throws Exception;
    List<CdtDTO> buscarTodos();
}

package com.Bankcol.BankColApp.service;

import com.Bankcol.BankColApp.dto.SucursalDTO;
import com.Bankcol.BankColApp.dto.TransaccionDTO;

import java.util.List;

public interface TransaccionService {
    List<TransaccionDTO> buscarTodos();
    TransaccionDTO guardarNuevaTransaccion(TransaccionDTO transaccionDTO) throws Exception;
}

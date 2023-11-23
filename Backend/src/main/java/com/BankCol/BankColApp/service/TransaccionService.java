package com.BankCol.BankColApp.service;

import com.BankCol.BankColApp.domain.Transaccion;
import com.BankCol.BankColApp.dto.TransaccionDTO;

import java.util.List;

public interface TransaccionService {
    TransaccionDTO guardarNuevaTransaccion(TransaccionDTO transaccionDTO) throws Exception;
    List<TransaccionDTO> buscarTodos();
}

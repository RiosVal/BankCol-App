package com.BankCol.BankColApp.service;

import com.BankCol.BankColApp.dto.CuentaDTO;

import java.util.List;

public interface CuentaService {
    CuentaDTO guardarNuevaCuenta(CuentaDTO cuentaDTO) throws Exception;

    List<CuentaDTO> buscarTodos();
}

package com.BankCol.BankColApp.service;

import com.BankCol.BankColApp.dto.ClienteDTO;
import com.BankCol.BankColApp.dto.TipoCuentaDTO;

import java.util.List;

public interface TipoCuentaService {
    public TipoCuentaDTO guardarNuevoTipoCuenta(TipoCuentaDTO tipoCuentaDTO) throws Exception;
    List<TipoCuentaDTO> buscarTodos();
    TipoCuentaDTO buscarPorId(Integer id) throws Exception;
    TipoCuentaDTO buscarPorDescripcion(String descripcion) throws Exception;
}

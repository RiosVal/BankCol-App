package com.BankCol.BankColApp.service;

import com.BankCol.BankColApp.domain.Sucursal;
import com.BankCol.BankColApp.dto.SucursalDTO;

import java.util.List;

public interface SucursalService {
    public SucursalDTO guardarNuevaSucursal(SucursalDTO sucursalDTO) throws Exception;
    List<SucursalDTO> buscarTodos();
    SucursalDTO buscarPorId(Integer id) throws Exception;

}

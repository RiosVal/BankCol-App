package com.BankCol.BankColApp.service;

import com.BankCol.BankColApp.dto.EstadoCdtDTO;

import java.util.List;

public interface EstadoCdtService {
    public EstadoCdtDTO guardarNuevoEstadoCdt(EstadoCdtDTO estadoCdtDTO) throws Exception;

    List<EstadoCdtDTO> buscarTodos();
    EstadoCdtDTO buscarPorId(Integer id) throws Exception;
    EstadoCdtDTO buscarPorDescripcion(String descripcion) throws Exception;


}

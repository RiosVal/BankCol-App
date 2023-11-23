package com.BankCol.BankColApp.service;

import com.BankCol.BankColApp.domain.Consignacion;
import com.BankCol.BankColApp.dto.ConsignacionDTO;

import java.util.List;

public interface ConsignacionService {
    ConsignacionDTO guardarNuevaConsignacion(ConsignacionDTO consignacionDTO) throws Exception;

    List<ConsignacionDTO> buscarTodos();
}

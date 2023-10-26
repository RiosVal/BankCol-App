package com.Bankcol.BankColApp.service;

import com.Bankcol.BankColApp.dto.ConsignacionDTO;

import java.util.List;


public interface ConsignacionService {
    ConsignacionDTO guardarNuevaConsignacionn(ConsignacionDTO consignacionDTO) throws Exception;
    List<ConsignacionDTO> buscarTodos();
}

package com.BankCol.BankColApp.service;

import com.BankCol.BankColApp.dto.CdtDTO;

import java.util.List;

public interface CdtService {
    CdtDTO guardarNuevoCdt(CdtDTO cdtDTO) throws Exception;
    List<CdtDTO> buscarTodos();

}

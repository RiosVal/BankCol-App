package com.Bankcol.BankColApp.service;

import com.Bankcol.BankColApp.dto.CdtDTO;

import java.util.List;

public interface CdtService {
    CdtDTO guardarNuevoCdt(CdtDTO cdtDTO) throws Exception;
    List<CdtDTO> buscarTodos();
}

package com.BankCol.BankColApp.service;

import com.BankCol.BankColApp.dto.RetiroDTO;

import java.util.List;

public interface RetiroService {
    RetiroDTO guardarNuevoRetiro(RetiroDTO retiroDTO) throws Exception;
    List<RetiroDTO> buscarTodos();
}

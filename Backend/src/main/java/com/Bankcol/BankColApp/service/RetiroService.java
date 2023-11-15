package com.Bankcol.BankColApp.service;

import com.Bankcol.BankColApp.dto.RetiroDTO;

import java.util.List;


public interface RetiroService {

   List<RetiroDTO> buscarTodos();
   RetiroDTO guardarNuevoRetiro(RetiroDTO retiroDTO) throws Exception;

}

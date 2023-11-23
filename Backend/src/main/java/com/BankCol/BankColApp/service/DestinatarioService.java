package com.BankCol.BankColApp.service;

import com.BankCol.BankColApp.dto.DestinatarioDTO;

import java.util.List;

public interface DestinatarioService {
    DestinatarioDTO guardarNuevoDestinatario(DestinatarioDTO destinatarioDTO) throws Exception;

    List<DestinatarioDTO> buscarTodos();
    DestinatarioDTO buscarPorId(Integer id) throws Exception;
    DestinatarioDTO buscarPorCedula(Integer cedula) throws Exception;
}

package com.Bankcol.BankColApp.service.impl;

import com.Bankcol.BankColApp.domain.Destinatario;
import com.Bankcol.BankColApp.dto.DestinatarioDTO;
import com.Bankcol.BankColApp.mapper.DestinatarioMapper;
import com.Bankcol.BankColApp.repository.DestinatarioRepository;
import com.Bankcol.BankColApp.service.DestinatarioService;
import org.springframework.stereotype.Service;

@Service
public class DestinatarioServiceImpl implements DestinatarioService {

    private final DestinatarioRepository destinatarioRepository;

    public DestinatarioServiceImpl(DestinatarioRepository destinatarioRepository) {
        this.destinatarioRepository = destinatarioRepository;
    }

    @Override
    public DestinatarioDTO guardarNuevoDestinatario(DestinatarioDTO destinatarioDTO) throws Exception {
        if (destinatarioDTO == null) {throw new Exception("Destinatario nulo");}

        if (destinatarioDTO.getNumcuenta_destinatario() == null ) {
            throw new Exception("Número de cuenta nulo");
        }
        if (destinatarioDTO.getBanco_destinatario() == null || destinatarioDTO.getBanco_destinatario().trim().isEmpty()) {
            throw new Exception("Banco vacío");
        }
        if (destinatarioDTO.getCedula_destinatario() == null ) {
            throw new Exception("Cédula vacía");
        }
        if (destinatarioDTO.getNombre_destinatario() == null || destinatarioDTO.getNombre_destinatario().trim().isEmpty()) {
            throw new Exception("Nombre vacío");
        }
        if (destinatarioDTO.getApellido_destinatario() == null || destinatarioDTO.getApellido_destinatario().trim().isEmpty()){
            throw new Exception("Apellido vacio");
        }
        if (destinatarioDTO.getCuenta_favorita() == null) {
            throw new Exception("Cuenta favorita vacía");
        }

        Destinatario destinatario = DestinatarioMapper.dtoToDomain(destinatarioDTO);
        destinatario = destinatarioRepository.save(destinatario);
        destinatarioDTO = DestinatarioMapper.domainToDto(destinatario);
        return destinatarioDTO;
    }
}

package com.Bankcol.BankColApp.service.impl;

import com.Bankcol.BankColApp.domain.TipoCuenta;
import com.Bankcol.BankColApp.dto.TipoCuentaDTO;
import com.Bankcol.BankColApp.mapper.TipoCuentaMapper;
import com.Bankcol.BankColApp.repository.TipoCuentaRepository;
import com.Bankcol.BankColApp.service.TipoCuentaService;
import org.springframework.stereotype.Service;

@Service
public class TipoCuentaImpl implements TipoCuentaService {

    private final TipoCuentaRepository tipoCuentaRepository;

    public TipoCuentaImpl(TipoCuentaRepository tipoCuentaRepository) {
        this.tipoCuentaRepository = tipoCuentaRepository;
    }

    @Override
    public TipoCuentaDTO guardarNuevoTipoCuenta(TipoCuentaDTO tipoCuentaDTO) throws Exception {
        //1. Validar los datos del tipo de cuenta
        if (tipoCuentaDTO == null) {
            throw new Exception("El tipo de dato es nulo");
        }

        if (tipoCuentaDTO.getDescripcion() == null || tipoCuentaDTO.getDescripcion().trim().isEmpty()){
            throw new Exception("Descripción vacía");
        }


        //2. Registrar el tipo de cuenta en DB mapeando desde DTO a domain
        TipoCuenta tipoCuenta = TipoCuentaMapper.dtoToDomain(tipoCuentaDTO);

        tipoCuenta = tipoCuentaRepository.save(tipoCuenta);

        return TipoCuentaMapper.domainToDto(tipoCuenta);
    }
}
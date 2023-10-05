package com.Tecnicas.BancoApp.service.impl;

import com.Tecnicas.BancoApp.domain.TipoCuenta;
import com.Tecnicas.BancoApp.dto.TipoCuentaDTO;
import com.Tecnicas.BancoApp.mapper.TipoCuentaMapper;
import com.Tecnicas.BancoApp.repository.TipoCuentaRepository;
import com.Tecnicas.BancoApp.service.TipoCuentaService;
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


        //3. Retornar el tipo de cuenta mappeado en DTO
        tipoCuentaDTO = TipoCuentaMapper.domainToDto(tipoCuenta);

        return tipoCuentaDTO;
    }
}

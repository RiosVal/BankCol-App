package com.Bankcol.BankColApp.service.impl;

import com.Bankcol.BankColApp.domain.Retiro;
import com.Bankcol.BankColApp.dto.RetiroDTO;
import com.Bankcol.BankColApp.mapper.RetiroMapper;
import com.Bankcol.BankColApp.repository.CuentaRepository;
import com.Bankcol.BankColApp.repository.RetiroRepository;
import com.Bankcol.BankColApp.service.RetiroService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RetiroServiceImpl implements RetiroService {

    private final RetiroRepository retiroRepository;
    private final CuentaRepository cuentaRepository;

    public RetiroServiceImpl(RetiroRepository retiroRepository, CuentaRepository cuentaRepository) {
        this.retiroRepository = retiroRepository;
        this.cuentaRepository = cuentaRepository;
    }

    @Override
    public List<RetiroDTO> buscarTodos() {
        return RetiroMapper.domainToDtoList(retiroRepository.findAll());
    }

    @Override
    public RetiroDTO guardarNuevoRetiro(RetiroDTO retiroDTO) throws Exception {
        if(retiroDTO==null){
            throw new Exception("Retiro vaacio");
        }

        if (retiroDTO.getFecha()==null){
            throw new Exception("fecha vacia");
        }

        if (retiroDTO.getMonto()==null){
            throw new Exception("Monto vacio");
        }
        if(retiroDTO.getCuentaId()==null){
            throw new Exception("Inscriba una cuenta");
        }

        Retiro retiro= RetiroMapper.dtoToDomain(retiroDTO);
        retiro = retiroRepository.save(retiro);
        retiroDTO = RetiroMapper.domainToDto(retiro);

        return retiroDTO;

    }
}

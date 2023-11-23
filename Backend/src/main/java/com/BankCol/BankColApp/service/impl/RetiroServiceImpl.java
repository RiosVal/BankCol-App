package com.BankCol.BankColApp.service.impl;

import com.BankCol.BankColApp.domain.Consignacion;
import com.BankCol.BankColApp.domain.Cuenta;
import com.BankCol.BankColApp.domain.Retiro;
import com.BankCol.BankColApp.dto.RetiroDTO;
import com.BankCol.BankColApp.mapper.RetiroMapper;
import com.BankCol.BankColApp.repository.CuentaRepository;
import com.BankCol.BankColApp.repository.RetiroRepository;
import com.BankCol.BankColApp.service.RetiroService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RetiroServiceImpl implements RetiroService {

    private final RetiroRepository retiroRepository;
    private final CuentaRepository cuentaRepository;

    public RetiroServiceImpl(RetiroRepository retiroRepository, CuentaRepository cuentaRepository) {
        this.retiroRepository = retiroRepository;
        this.cuentaRepository = cuentaRepository;
    }

    @Override
    public RetiroDTO guardarNuevoRetiro(RetiroDTO retiroDTO) throws Exception {
        //1. Validar que la COnsignacionDTO no sea nula
        if(retiroDTO == null) { throw new Exception("Retiro nulo"); }

        if(retiroDTO.getCodigoRetiro() == null || retiroDTO.getCodigoRetiro().isEmpty()) { throw new Exception("Codigo de retiro vacío"); }

        if(retiroDTO.getFecha() == null) { throw new Exception("Fecha de retiro vacía"); }

        if(retiroDTO.getMonto() == null || retiroDTO.getMonto() == 0) { throw new Exception("Monto de retiro vacío"); }

        if(retiroDTO.getCuentaId() == null || retiroDTO.getCuentaId() == 0) { throw new Exception("Cuenta de retiro vacía"); }


        //Validar que no exista un retiro con el mismo código
        Optional<Retiro> retiroOptional = retiroRepository.findRetiroByCodigoRetiro(retiroDTO.getCodigoRetiro());
        if(retiroOptional.isPresent()) {
            throw new Exception("Ya existe un retiro con codigo " + retiroDTO.getCodigoRetiro());
        }

        //Validar si existe la cuenta
        Optional<Cuenta> cuentaOptional = cuentaRepository.findById(retiroDTO.getCuentaId());
        if(cuentaOptional.isEmpty()){
            throw  new Exception("No existe la cuenta con id " + retiroDTO.getCuentaId());
        }


        Retiro retiro = RetiroMapper.dtoToDomain(retiroDTO);
        retiro.setCuentaId(cuentaOptional.get());

        retiro = retiroRepository.save(retiro);

        return RetiroMapper.domainToDto(retiro);
    }

    @Override
    public List<RetiroDTO> buscarTodos() {
        return RetiroMapper.domainToDtoList(retiroRepository.findAll());
    }
}

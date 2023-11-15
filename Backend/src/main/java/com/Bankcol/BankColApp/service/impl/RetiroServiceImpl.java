package com.Bankcol.BankColApp.service.impl;

import com.Bankcol.BankColApp.domain.Cuenta;
import com.Bankcol.BankColApp.domain.Retiro;
import com.Bankcol.BankColApp.dto.RetiroDTO;
import com.Bankcol.BankColApp.mapper.RetiroMapper;
import com.Bankcol.BankColApp.repository.CuentaRepository;
import com.Bankcol.BankColApp.repository.RetiroRepository;

import com.Bankcol.BankColApp.service.RetiroService;
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
    public List<RetiroDTO> buscarTodos() {
        return RetiroMapper.domainToDtoList(retiroRepository.findAll());

    }

    @Override
    public RetiroDTO guardarNuevoRetiro(RetiroDTO retiroDTO) throws Exception {
        if(retiroDTO==null){
            throw new Exception("Retiro vacio");
        }

        if (retiroDTO.getFecha()==null){
            throw new Exception("fecha vacia");
        }

        if (retiroDTO.getMonto()==null || retiroDTO.getMonto()==0){
            throw new Exception("Monto vacio");
        }

        if(retiroDTO.getCuentaId()==null){
            throw new Exception("Cuenta vacia");
        }

        //Se verifica que la cuenta exista
        Optional<Cuenta> cuentaOptional = cuentaRepository.findByNoCuenta(retiroDTO.getCuentaId());
        if (cuentaOptional.isEmpty()) {
            throw new Exception("No se puede registrar el retiro puesto que no existe una cuenta con el número " + retiroDTO.getCuentaId());
        }





        //Se verifica que el monto a retirar no sea mayor al monto disponible
        /*if(retiroDTO.getMonto()>J){
            throw new Exception("Monto mayor al permitido");
        }*/

        Retiro retiro= RetiroMapper.dtoToDomain(retiroDTO);
        //retiroDTO.setCuentaId();
        retiro = retiroRepository.save(retiro);
        retiroDTO = RetiroMapper.domainToDto(retiro);

        return retiroDTO;

    }
}

package com.BankCol.BankColApp.service.impl;

import com.BankCol.BankColApp.domain.Consignacion;
import com.BankCol.BankColApp.domain.Cuenta;
import com.BankCol.BankColApp.dto.ConsignacionDTO;
import com.BankCol.BankColApp.mapper.ConsignacionMapper;
import com.BankCol.BankColApp.repository.ConsignacionRepository;
import com.BankCol.BankColApp.repository.CuentaRepository;
import com.BankCol.BankColApp.service.ConsignacionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsignacionServiceImpl implements ConsignacionService {
    private final ConsignacionRepository consignacionRepository;
    private final CuentaRepository cuentaRepository;

    public ConsignacionServiceImpl(ConsignacionRepository consignacionRepository, CuentaRepository cuentaRepository) {
        this.consignacionRepository = consignacionRepository;
        this.cuentaRepository = cuentaRepository;
    }

    @Override
    public ConsignacionDTO guardarNuevaConsignacion(ConsignacionDTO consignacionDTO) throws Exception {
        //1. Validar que la COnsignacionDTO no sea nula
        if(consignacionDTO == null) { throw new Exception("Consignación nula"); }

        if(consignacionDTO.getCodigoConsignacion() == null || consignacionDTO.getCodigoConsignacion().isEmpty()) { throw new Exception("Codigo de consignacion vacío"); }

        if(consignacionDTO.getFecha() == null) { throw new Exception("Fecha de consignacion vacía"); }

        if(consignacionDTO.getMonto() == null || consignacionDTO.getMonto() == 0) { throw new Exception("Monto de consignacion vacío"); }

        if(consignacionDTO.getCuentaId() == null || consignacionDTO.getCuentaId() == 0) { throw new Exception("Id de cliente de consignacion vacío"); }


        //Validar que no exista una consignación con el mismo código
        Optional<Consignacion> consignacionOptional = consignacionRepository.findConsignacionByCodigoConsignacion(consignacionDTO.getCodigoConsignacion());
        if(consignacionOptional.isPresent()) {
            throw new Exception("Ya existe una consignación con codigo "+ consignacionDTO.getCodigoConsignacion());
        }

        //Validar si existe la cuenta
        Optional<Cuenta> cuentaOptional = cuentaRepository.findById(consignacionDTO.getCuentaId());
        if(cuentaOptional.isEmpty()){
            throw  new Exception("No existe la cuenta con id " + consignacionDTO.getCuentaId());
        }

        Consignacion consignacion = ConsignacionMapper.dtoToDomain(consignacionDTO);
        consignacion.setCuentaId(cuentaOptional.get());

        consignacion = consignacionRepository.save(consignacion);

        return ConsignacionMapper.domainToDto(consignacion);
    }

    @Override
    public List<ConsignacionDTO> buscarTodos() {
        return ConsignacionMapper.domainToDtoList(consignacionRepository.findAll());
    }
}

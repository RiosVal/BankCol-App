package com.Bankcol.BankColApp.service.impl;

import com.Bankcol.BankColApp.domain.Consignacion;
import com.Bankcol.BankColApp.dto.ConsignacionDTO;
import com.Bankcol.BankColApp.mapper.ConsignacionMapper;
import com.Bankcol.BankColApp.repository.ConsignacionRepository;
import com.Bankcol.BankColApp.service.ConsignacionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsignacionServiceImpl implements ConsignacionService {

    private final ConsignacionRepository consignacionRepository;

    public ConsignacionServiceImpl(ConsignacionRepository consignacionRepository) {
        this.consignacionRepository = consignacionRepository;
    }

    @Override
    public ConsignacionDTO guardarNuevaConsignacionn(ConsignacionDTO consignacionDTO) throws Exception {

        if (consignacionDTO == null) {
            throw new Exception("La consignacion es nula");
        }
        if(consignacionDTO.getFecha() == null){
            throw new Exception("La fecha no puede ser nula");
        }
        if(consignacionDTO.getMonto() == null){
            throw new Exception("El valor no puede ser nulo");
        }
        if(consignacionDTO.getClienteId() == null){
            throw new Exception("El numero de cuenta no puede ser nulo");
        }

        Consignacion consgnacion= ConsignacionMapper.dtoToDomain(consignacionDTO);
        consgnacion = consignacionRepository.save(consgnacion);
        consignacionDTO = ConsignacionMapper.domainToDto(consgnacion);

        return consignacionDTO;
    }

    @Override
    public List<ConsignacionDTO> buscarTodos() {
        return null;
    }
}

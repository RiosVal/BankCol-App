package com.Bankcol.BankColApp.service.impl;

import com.Bankcol.BankColApp.domain.Cliente;
import com.Bankcol.BankColApp.domain.Consignacion;
import com.Bankcol.BankColApp.dto.ConsignacionDTO;
import com.Bankcol.BankColApp.mapper.ConsignacionMapper;
import com.Bankcol.BankColApp.repository.ClienteRepository;
import com.Bankcol.BankColApp.repository.ConsignacionRepository;
import com.Bankcol.BankColApp.service.ConsignacionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsignacionServiceImpl implements ConsignacionService {

    private final ConsignacionRepository consignacionRepository;
    private final ClienteRepository clienteRepository;


    public ConsignacionServiceImpl(ConsignacionRepository consignacionRepository, ClienteRepository clienteRepository){
        this.consignacionRepository = consignacionRepository;
        this.clienteRepository = clienteRepository;
    }

    @Override
    public ConsignacionDTO guardarNuevaConsignacionn(ConsignacionDTO consignacionDTO) throws Exception {

        if (consignacionDTO == null) {
            throw new Exception("La consignacion es nula");
        }
        if(consignacionDTO.getFecha() == null || consignacionDTO.getFecha().toString().trim().isEmpty()){
            throw new Exception("La fecha no puede ser nula");
        }
        if(consignacionDTO.getMonto() == null || consignacionDTO.getMonto() == 0){
            throw new Exception("El monto no puede ser nulo");
        }
        if(consignacionDTO.getClienteId() == null || consignacionDTO.getClienteId() == 0){
            throw new Exception("El numero de cuenta no puede ser nulo");
        }

        Optional<Cliente> clienteOptional = clienteRepository.findById(consignacionDTO.getClienteId());
        if (clienteOptional.isEmpty()) {
            throw new Exception("No se puede registrar el cdt puesto que no existe un cliente con el ID " + consignacionDTO.getClienteId());
        }

        Consignacion consignacion= ConsignacionMapper.dtoToDomain(consignacionDTO);
        consignacion.setCliente(clienteOptional.get());
        consignacion = consignacionRepository.save(consignacion);

        return ConsignacionMapper.domainToDto(consignacion);
    }

    @Override
    public List<ConsignacionDTO> buscarTodos() {
        return ConsignacionMapper.domainToDtoList(consignacionRepository.findAll());
    }
}

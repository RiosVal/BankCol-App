package com.BankCol.BankColApp.service.impl;

import com.BankCol.BankColApp.domain.Cdt;
import com.BankCol.BankColApp.domain.Cliente;
import com.BankCol.BankColApp.domain.EstadoCdt;
import com.BankCol.BankColApp.domain.Sucursal;
import com.BankCol.BankColApp.dto.CdtDTO;
import com.BankCol.BankColApp.mapper.CdtMapper;
import com.BankCol.BankColApp.repository.CdtRepository;
import com.BankCol.BankColApp.repository.ClienteRepository;
import com.BankCol.BankColApp.repository.EstadoCdtRepository;
import com.BankCol.BankColApp.repository.SucursalRepository;
import com.BankCol.BankColApp.service.CdtService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CdtServiceImpl implements CdtService {
    private final CdtRepository cdtRepository;
    private final ClienteRepository clienteRepository;
    private final SucursalRepository sucursalRepository;
    private final EstadoCdtRepository estadoCdtRepository;

    public CdtServiceImpl(CdtRepository cdtRepository, ClienteRepository clienteRepository, SucursalRepository sucursalRepository, EstadoCdtRepository estadoCdtRepository) {
        this.cdtRepository = cdtRepository;
        this.clienteRepository = clienteRepository;
        this.sucursalRepository = sucursalRepository;
        this.estadoCdtRepository = estadoCdtRepository;
    }

    @Override
    public CdtDTO guardarNuevoCdt(CdtDTO cdtDTO) throws Exception {
        //1. Validar que el CdtDTO no sea nulo
        if (cdtDTO == null) { throw new Exception("Cdt nulo"); }

        if(cdtDTO.getNumero() == null) { throw new Exception("Numero de cdt vacío"); }

        if(cdtDTO.getFechaInicio() == null ) { throw new Exception("Fecha de inicio de cdt vacía"); }

        if(cdtDTO.getFechaFin() == null) { throw new Exception("Fecha fin de cdt vacía"); }

        if(cdtDTO.getTasa() == null || cdtDTO.getTasa() <= 0) { throw new Exception("Tasa de cdt vacía o incorrecta"); }

        if(cdtDTO.getMontoInvertido() == null || cdtDTO.getMontoInvertido() < 50) { throw new Exception("Monto de cdt vacío o debaje del mínimo"); }

        if(cdtDTO.getMontoFinal() == null || cdtDTO.getMontoFinal() < cdtDTO.getMontoInvertido()) { throw new Exception("Monto final de cdt vacío o menor al invertido"); }

        if(cdtDTO.getClienteId() == null || cdtDTO.getClienteId() == 0) { throw new Exception("Cliente de cdt vacío o incorrecta"); }

        if(cdtDTO.getSucursalId() == null || cdtDTO.getSucursalId() == 0) { throw new Exception("Sucursal de cdt vacía o incorrecta"); }

        if(cdtDTO.getEstadoCdtId() == null || cdtDTO.getEstadoCdtId() == 0) { throw new Exception("Estado de cdt vacío o incorrecto"); }

        //Validar que no exista un cdt con el mismo numero
        Optional<Cdt> cdtOptional = cdtRepository.findCdtByNumero(cdtDTO.getNumero());
        if(cdtOptional.isPresent()) {
            throw new Exception("Ya existe un cdt con ese número");
        }

        //Validar si existe el cliente
        Optional<Cliente> clienteOptional = clienteRepository.findById(cdtDTO.getClienteId());
        if (clienteOptional.isEmpty()) {
            throw new Exception("No existe el cliente con id "+ cdtDTO.getClienteId());
        }

        //Validar si existe la sucursal
        Optional<Sucursal> sucursalOptional = sucursalRepository.findById(cdtDTO.getSucursalId());
        if (sucursalOptional.isEmpty()) {
            throw new Exception("No existe la sucursal con id "+ cdtDTO.getSucursalId());
        }

        //Validar si existe el estado
        Optional<EstadoCdt> estadoCdtOptional = estadoCdtRepository.findById(cdtDTO.getEstadoCdtId());
        if (estadoCdtOptional.isEmpty()) {
            throw new Exception("No existe el estado de cdt con id "+ cdtDTO.getEstadoCdtId());
        }

        Cdt cdt = CdtMapper.dtoToDomain(cdtDTO);
        cdt.setClienteId(clienteOptional.get());
        cdt.setSucursal(sucursalOptional.get());
        cdt.setEstadoCdt(estadoCdtOptional.get());

        cdt = cdtRepository.save(cdt);

        return CdtMapper.domainToDto(cdt);
    }

    @Override
    public List<CdtDTO> buscarTodos() {
        return CdtMapper.domainToDtoList(cdtRepository.findAll());
    }
}

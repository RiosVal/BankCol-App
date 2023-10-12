package com.Bankcol.BankColApp.service.impl;

import com.Bankcol.BankColApp.domain.Cdt;
import com.Bankcol.BankColApp.domain.Cliente;
import com.Bankcol.BankColApp.domain.EstadoCdt;
import com.Bankcol.BankColApp.domain.Sucursal;
import com.Bankcol.BankColApp.dto.CdtDTO;
import com.Bankcol.BankColApp.mapper.CdtMapper;
import com.Bankcol.BankColApp.repository.CdtRepository;
import com.Bankcol.BankColApp.repository.ClienteRepository;
import com.Bankcol.BankColApp.repository.EstadoCdtRepository;
import com.Bankcol.BankColApp.repository.SucursalRepository;
import com.Bankcol.BankColApp.service.CdtService;
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
        if (cdtDTO == null) {
            throw new Exception("EL cdt no puede ser nulo");
        }
        if (cdtDTO.getFecha_inicio() == null) {
            throw new Exception("Fecha de inicio nula");
        }
        if (cdtDTO.getFecha_fin() == null) {
            throw new Exception("Fecha de fin nula");
        }
        if (cdtDTO.getTasa() == null) {
            throw new Exception("Tasa vacía");
        }
        if (cdtDTO.getMonto_invertido() == null) {
            throw new Exception("Monto invertido vacío");
        }
        if (cdtDTO.getMonto_final() == null) {
            throw new Exception("Monto final vacío");
        }
        if (cdtDTO.getClienteId() == null || cdtDTO.getClienteId() == 0) {
            throw new Exception("Cliente ID vacío");
        }
        if (cdtDTO.getSucursalId() == null || cdtDTO.getSucursalId() == 0) {
            throw new Exception("Sucursal ID vacío");
        }
        if(cdtDTO.getEstadoCdtId() == null || cdtDTO.getEstadoCdtId() == 0){
            throw new Exception("Estado cdt vacío");
        }

        Optional<Cliente> clienteOptional = clienteRepository.findById(cdtDTO.getClienteId());
        if (clienteOptional.isEmpty()) {
            throw new Exception("No se puede registrar el cdt puesto que no existe un cliente con el ID " + cdtDTO.getClienteId());
        }

        Optional<Sucursal> sucursalOptional = sucursalRepository.findById(cdtDTO.getSucursalId());
        if (sucursalOptional.isEmpty()) {
            throw new Exception("No se puede registrar el cdt puesto que no existe un cliente con el ID " + cdtDTO.getSucursalId());
        }

        Optional<EstadoCdt> estadoCdtOptional = estadoCdtRepository.findById(cdtDTO.getEstadoCdtId());
        if (estadoCdtOptional.isEmpty()) {
            throw new Exception("No se puede registrar el cdt puesto que no existe un cliente con el ID " + cdtDTO.getEstadoCdtId());
        }

        Cdt cdt = CdtMapper.dtoToDomain(cdtDTO);
        cdt.setCliente(clienteOptional.get());
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

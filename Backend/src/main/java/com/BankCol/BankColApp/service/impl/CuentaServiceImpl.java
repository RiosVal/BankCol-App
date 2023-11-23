package com.BankCol.BankColApp.service.impl;

import com.BankCol.BankColApp.domain.Cliente;
import com.BankCol.BankColApp.domain.Cuenta;
import com.BankCol.BankColApp.domain.Sucursal;
import com.BankCol.BankColApp.domain.TipoCuenta;
import com.BankCol.BankColApp.dto.CuentaDTO;
import com.BankCol.BankColApp.mapper.CuentaMapper;
import com.BankCol.BankColApp.repository.ClienteRepository;
import com.BankCol.BankColApp.repository.CuentaRepository;
import com.BankCol.BankColApp.repository.SucursalRepository;
import com.BankCol.BankColApp.repository.TipoCuentaRepository;
import com.BankCol.BankColApp.service.CuentaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CuentaServiceImpl implements CuentaService {

    private final CuentaRepository cuentaRepository;
    private final TipoCuentaRepository tipoCuentaRepository;
    private final ClienteRepository clienteRepository;
    private final SucursalRepository sucursalRepository;

    public CuentaServiceImpl(CuentaRepository cuentaRepository, TipoCuentaRepository tipoCuentaRepository, ClienteRepository clienteRepository, SucursalRepository sucursalRepository) {
        this.cuentaRepository = cuentaRepository;
        this.tipoCuentaRepository = tipoCuentaRepository;
        this.clienteRepository = clienteRepository;
        this.sucursalRepository = sucursalRepository;
    }

    @Override
    public CuentaDTO guardarNuevaCuenta(CuentaDTO cuentaDTO) throws Exception {

        if(cuentaDTO == null) { throw new Exception("Cuenta nula"); }

        if(cuentaDTO.getNumeroCuenta() == null || cuentaDTO.getNumeroCuenta() == 0) { throw new Exception("Numero de cuenta vacío"); }

        if(cuentaDTO.getMontoDisponible() == null) { throw new Exception("Monto disponible vacío"); }

        if(cuentaDTO.getTipoCuentaId() == null || cuentaDTO.getTipoCuentaId() == 0) { throw new Exception("Tipo de cuenta vacío o inválido"); }

        if(cuentaDTO.getClienteId() == null || cuentaDTO.getClienteId() == 0) { throw new Exception("Cliente vacío o inválido"); }

        if(cuentaDTO.getSucursalId() == null || cuentaDTO.getSucursalId() == 0) { throw new Exception("Sucursal vacío o inválido"); }

        Optional<Cuenta> cuentaOptional = cuentaRepository.findCuentaByNumeroCuenta(cuentaDTO.getNumeroCuenta());
        if(cuentaOptional.isPresent()) {
            throw new Exception("Ya existe una cuenta con número "+ cuentaDTO.getNumeroCuenta());
        }

        Optional<TipoCuenta> tipoCuentaOptional = tipoCuentaRepository.findById(cuentaDTO.getTipoCuentaId());
        if(tipoCuentaOptional.isEmpty()){
            throw new Exception("No existe un tipo de cuenta con id "+ cuentaDTO.getTipoCuentaId());
        }

        Optional<Cliente> clienteOptional = clienteRepository.findById(cuentaDTO.getClienteId());
        if(clienteOptional.isEmpty()) {
            throw new Exception("No existe un cliente con id "+ cuentaDTO.getClienteId());
        }

        Optional<Sucursal> sucursalOptional = sucursalRepository.findById(cuentaDTO.getSucursalId());
        if(sucursalOptional.isEmpty()) {
            throw new Exception("No existe una sucursal con id "+ cuentaDTO.getSucursalId());
        }

        Cuenta cuenta = CuentaMapper.dtoToDomain(cuentaDTO);
        cuenta.setTipoCuenta(tipoCuentaOptional.get());
        cuenta.setClienteId(clienteOptional.get());
        cuenta.setSucursalId(sucursalOptional.get());

        cuenta = cuentaRepository.save(cuenta);


        return CuentaMapper.domainToDto(cuenta);
    }

    @Override
    public List<CuentaDTO> buscarTodos() {
        return CuentaMapper.domainToDtoList(cuentaRepository.findAll());
    }
}

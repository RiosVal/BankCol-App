package com.Bankcol.BankColApp.service.impl;


import com.Bankcol.BankColApp.domain.Cliente;
import com.Bankcol.BankColApp.domain.Cuenta;
import com.Bankcol.BankColApp.domain.Sucursal;
import com.Bankcol.BankColApp.domain.TipoCuenta;
import com.Bankcol.BankColApp.dto.CuentaDTO;
import com.Bankcol.BankColApp.mapper.CuentaMapper;
import com.Bankcol.BankColApp.repository.CuentaRepository;
import com.Bankcol.BankColApp.repository.TipoCuentaRepository;
import com.Bankcol.BankColApp.repository.ClienteRepository;
import com.Bankcol.BankColApp.repository.SucursalRepository;
import com.Bankcol.BankColApp.service.CuentaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CuentaServiceImpl  implements CuentaService {

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

    public CuentaDTO guardarNuevaCuenta(CuentaDTO cuentaDTO) throws Exception {

        if (cuentaDTO == null) {
            throw new Exception("La cuenta es nula");
        }
        if(cuentaDTO.getNumero_cuenta() == null) {
            throw new Exception("El numero de cuenta no puede ser nulo o vacío");
        }
        if(cuentaDTO.getMonto_disponible() == null) {
            throw new Exception("El monto disponible no puede ser nulo o vacío");
        }
        if(cuentaDTO.getTipoCuentaId() == null) {
            throw new Exception("El tipo de cuenta no puede ser nulo o vacío");
        }
        if (cuentaDTO.getClienteId() == null) {
            throw new Exception("El cliente no puede ser nulo o vacío");
        }
        if (cuentaDTO.getSucursalId() == null) {
            throw new Exception("La sucursal no puede ser nula o vacía");
        }

        //Se verifica que el tipo de cuenta exista
        Optional <TipoCuenta> tipoCuentaOptional = tipoCuentaRepository.findById(cuentaDTO.getTipoCuentaId());
        if (tipoCuentaOptional.isEmpty()) {
            throw new Exception("No se puede registrar la cuenta puesto que no existe un tipo de cuenta con el ID " + cuentaDTO.getTipoCuentaId());
        }

        //Se verifica que el cliente exista
        Optional <Cliente> clienteOptional = clienteRepository.findById(cuentaDTO.getClienteId());
        if (clienteOptional.isEmpty()) {
            throw new Exception("No se puede registrar la cuenta puesto que no existe un cliente con el ID " + cuentaDTO.getClienteId());
        }

        //Se verifica que la sucursal exista
        Optional <Sucursal> sucursalOptional = sucursalRepository.findById(cuentaDTO.getSucursalId());
        if (sucursalOptional.isEmpty()) {
            throw new Exception("No se puede registrar la cuenta puesto que no existe una sucursal con el ID " + cuentaDTO.getSucursalId());
        }

        Cuenta cuenta = CuentaMapper.dtoToDomain(cuentaDTO);
        cuenta.setTipoCuenta(tipoCuentaOptional.get());
        cuenta.setCliente(clienteOptional.get());
        cuenta.setSucursal(sucursalOptional.get());
        cuenta = cuentaRepository.save(cuenta);

        return CuentaMapper.domainToDto(cuenta);
    }


    @Override
    public List<CuentaDTO> buscarTodos() {
        return null;
    }
}

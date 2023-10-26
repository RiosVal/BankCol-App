package com.Bankcol.BankColApp.service.impl;


import com.Bankcol.BankColApp.domain.Cuenta;
import com.Bankcol.BankColApp.dto.CuentaDTO;
import com.Bankcol.BankColApp.mapper.CuentaMapper;
import com.Bankcol.BankColApp.repository.CuentaRepository;
import com.Bankcol.BankColApp.service.CuentaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuentaServiceImpl  implements CuentaService {

    private final CuentaRepository cuentaRepository;

    public CuentaServiceImpl(CuentaRepository cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
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

        Cuenta cuenta = CuentaMapper.dtoToDomain(cuentaDTO);
        cuenta = cuentaRepository.save(cuenta);
        cuentaDTO = CuentaMapper.domainToDto(cuenta);

        return cuentaDTO;
    }


    @Override
    public List<CuentaDTO> buscarTodos() {
        return null;
    }
}

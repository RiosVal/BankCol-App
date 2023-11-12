package com.Bankcol.BankColApp.service.impl;

import com.Bankcol.BankColApp.domain.Sucursal;
import com.Bankcol.BankColApp.dto.SucursalDTO;
import com.Bankcol.BankColApp.mapper.SucursalMapper;
import com.Bankcol.BankColApp.repository.SucursalRepository;
import com.Bankcol.BankColApp.service.SucursalService;
import org.springframework.stereotype.Service;

@Service
public class SucursalServiceImpl implements SucursalService {
    private final SucursalRepository sucursalRepository;

    public SucursalServiceImpl(SucursalRepository sucursalRepository) {
        this.sucursalRepository = sucursalRepository;
    }

    @Override
    public SucursalDTO guardarNuevaSucursal(SucursalDTO sucursalDTO) throws Exception {
        if (sucursalDTO == null) {
            throw new Exception("La sucursal es nula");
        }
        if (sucursalDTO.getCiudad() == null || sucursalDTO.getCiudad().trim().isEmpty()){
            throw new Exception("Ciudad vacía");
        }
        if (sucursalDTO.getDireccion() == null || sucursalDTO.getDireccion().trim().isEmpty()){
            throw new Exception("Dirección vacía");
        }
        if (sucursalDTO.getTelefono() == null || sucursalDTO.getTelefono().trim().isEmpty()){
            throw new Exception("Teléfono vacío");
        }

        Sucursal sucursal = SucursalMapper.dtoToDomain(sucursalDTO);
        sucursal = sucursalRepository.save(sucursal);

        return SucursalMapper.domainToDto(sucursal);
    }
}

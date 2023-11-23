package com.BankCol.BankColApp.service.impl;

import com.BankCol.BankColApp.domain.Sucursal;
import com.BankCol.BankColApp.dto.SucursalDTO;
import com.BankCol.BankColApp.mapper.SucursalMapper;
import com.BankCol.BankColApp.repository.SucursalRepository;
import com.BankCol.BankColApp.service.SucursalService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SucursalServieImpl implements SucursalService {

    private final SucursalRepository sucursalRepository;

    public SucursalServieImpl(SucursalRepository sucursalRepository) {
        this.sucursalRepository = sucursalRepository;
    }

    @Override
    public SucursalDTO guardarNuevaSucursal(SucursalDTO sucursalDTO) throws Exception {
        //Validar los datos de la sucursal
        if(sucursalDTO.getCiudad() == null) { throw new Exception("La sucursal es nula"); }

        if(sucursalDTO.getDireccion() == null || sucursalDTO.getDireccion().isEmpty()) { throw new Exception("La direccion es vacía"); }

        if(sucursalDTO.getTelefono() == null || sucursalDTO.getTelefono().isEmpty()) { throw new Exception("El teléfono es vacío"); }


        //Registrar la sucursal en DB
        Sucursal sucursal = SucursalMapper.dtoToDomain(sucursalDTO);
        sucursal = sucursalRepository.save(sucursal);

        //Retornar el cliente mapeado en DTO
        sucursalDTO = SucursalMapper.domainToDto(sucursal);

        return sucursalDTO;
    }

    @Override
    public List<SucursalDTO> buscarTodos() {
        return SucursalMapper.domainToDtoList(sucursalRepository.findAll());
    }

    @Override
    public SucursalDTO buscarPorId(Integer id) throws Exception {
        if(id == null || id.equals(0)){
            throw new Exception("Id no valido");
        }
        return SucursalMapper.domainToDto(sucursalRepository.getReferenceById(id));
    }
}

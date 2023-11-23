package com.BankCol.BankColApp.service.impl;

import com.BankCol.BankColApp.domain.Cliente;
import com.BankCol.BankColApp.domain.TipoCuenta;
import com.BankCol.BankColApp.dto.TipoCuentaDTO;
import com.BankCol.BankColApp.mapper.TipoCuentaMapper;
import com.BankCol.BankColApp.repository.TipoCuentaRepository;
import com.BankCol.BankColApp.service.TipoCuentaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoCuentaServiceImpl implements TipoCuentaService {

    private final TipoCuentaRepository tipoCuentaRepository;

    public TipoCuentaServiceImpl(TipoCuentaRepository tipoCuentaRepository) {
        this.tipoCuentaRepository = tipoCuentaRepository;
    }

    @Override
    public TipoCuentaDTO guardarNuevoTipoCuenta(TipoCuentaDTO tipoCuentaDTO) throws Exception {
        //Validar los datos del tipo de cuenta
        if (tipoCuentaDTO == null ) { throw new Exception("El tipo de cuenta es nulo"); }

        if(tipoCuentaDTO.getDescripcion() == null || tipoCuentaDTO.getDescripcion().isEmpty()) { throw new Exception("La descripcion es vacía"); }

        //Validar que no exista un cliente con esa cedula
        Optional<TipoCuenta> tipoPorDescripcion = tipoCuentaRepository.findTipoCuentaByDescripcion(tipoCuentaDTO.getDescripcion());

        if (tipoPorDescripcion.isPresent()){
            throw new Exception("El tipo de cuenta "+ tipoCuentaDTO.getDescripcion() +" ya se encuentra registrado");
        }


        //Registrar el tipo de cuenta en DB
        TipoCuenta tipoCuenta = TipoCuentaMapper.dtoToDomain(tipoCuentaDTO);
        tipoCuenta = tipoCuentaRepository.save(tipoCuenta);

        //Retornar el cliente mapeado en DTO
        tipoCuentaDTO = TipoCuentaMapper.domainToDto(tipoCuenta);

        return tipoCuentaDTO;
    }

    @Override
    public List<TipoCuentaDTO> buscarTodos() {
        return TipoCuentaMapper.domainToDtoList(tipoCuentaRepository.findAll());
    }

    @Override
    public TipoCuentaDTO buscarPorId(Integer id) throws Exception{
        if(id == null || id.equals(0)){
            throw new Exception("Id no valido");
        }
        return TipoCuentaMapper.domainToDto(tipoCuentaRepository.getReferenceById(id));
    }

    @Override
    public TipoCuentaDTO buscarPorDescripcion(String descripcion) throws Exception{
        if(descripcion == null | descripcion.isEmpty()) {
            throw new Exception("Descripción nula");
        }
        return TipoCuentaMapper.domainToDto(tipoCuentaRepository.findByDescripcion(descripcion));
    }
}

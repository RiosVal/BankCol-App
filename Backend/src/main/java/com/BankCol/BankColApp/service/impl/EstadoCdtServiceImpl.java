package com.BankCol.BankColApp.service.impl;

import com.BankCol.BankColApp.domain.EstadoCdt;
import com.BankCol.BankColApp.dto.EstadoCdtDTO;
import com.BankCol.BankColApp.mapper.EstadoCdtMapper;
import com.BankCol.BankColApp.repository.EstadoCdtRepository;
import com.BankCol.BankColApp.service.EstadoCdtService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoCdtServiceImpl implements EstadoCdtService {

    private final EstadoCdtRepository estadoCdtRepository;

    public EstadoCdtServiceImpl(EstadoCdtRepository estadoCdtRepository) {
        this.estadoCdtRepository = estadoCdtRepository;
    }

    @Override
    public EstadoCdtDTO guardarNuevoEstadoCdt(EstadoCdtDTO estadoCdtDTO) throws Exception {

        if(estadoCdtDTO == null) { throw new Exception("El estado es nulo"); }

        if(estadoCdtDTO.getDescripcion() == null || estadoCdtDTO.getDescripcion().isEmpty()) { throw new Exception("La descripcion es vacía"); }

        //Validar que no esxista un estado cdt con esa descripcion
        Optional<EstadoCdt> estadoPorDescripcion = estadoCdtRepository.findEstadoCdtByDescripcion(estadoCdtDTO.getDescripcion());

        if(estadoPorDescripcion.isPresent()) {
            throw new Exception("El estado con descripción "+ estadoCdtDTO.getDescripcion() +" ya se encuentra registrado");
        }


        EstadoCdt estadoCdt = EstadoCdtMapper.dtoToDomain(estadoCdtDTO);
        estadoCdt = estadoCdtRepository.save(estadoCdt);

        estadoCdtDTO = EstadoCdtMapper.domainToDto(estadoCdt);

        return estadoCdtDTO;
    }

    @Override
    public List<EstadoCdtDTO> buscarTodos() {
        return EstadoCdtMapper.domainToDtoList(estadoCdtRepository.findAll());
    }

    @Override
    public EstadoCdtDTO buscarPorId(Integer id) throws Exception {
        if(id == null || id.equals(0)) { throw new Exception("Id nulo"); }
        return EstadoCdtMapper.domainToDto(estadoCdtRepository.getReferenceById(id));
    }

    @Override
    public EstadoCdtDTO buscarPorDescripcion(String descripcion) throws Exception {
        if (descripcion == null || descripcion.isEmpty()) { throw new Exception("Descripción nula"); }
        return EstadoCdtMapper.domainToDto(estadoCdtRepository.findByDescripcion(descripcion));
    }
}

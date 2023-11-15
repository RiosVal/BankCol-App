package com.Bankcol.BankColApp.service.impl;


import com.Bankcol.BankColApp.domain.EstadoCdt;
import com.Bankcol.BankColApp.dto.EstadoCdtDTO;
import com.Bankcol.BankColApp.mapper.EstadoCdtMapper;
import com.Bankcol.BankColApp.repository.EstadoCdtRepository;
import com.Bankcol.BankColApp.service.EstadoCdtService;
import org.springframework.stereotype.Service;

@Service
public class EstadoCdtServiceImpl implements EstadoCdtService {

    private final EstadoCdtRepository estadoCdtRepository;

    public EstadoCdtServiceImpl(EstadoCdtRepository estadoCdtRepository) {
        this.estadoCdtRepository = estadoCdtRepository;
    }

    @Override
    public EstadoCdtDTO guardarNuevoEstadocdt(EstadoCdtDTO estadoCdtDTO) throws Exception {
        if (estadoCdtDTO == null){
            throw new Exception("Estado del CDT vacio");
        }
        if (estadoCdtDTO.getDescripcion()==null){
            throw new Exception("Descripcion vacia");
        }
        EstadoCdt estadoCdt = EstadoCdtMapper.dtoToDomain(estadoCdtDTO);
        estadoCdt = estadoCdtRepository.save(estadoCdt);

        return EstadoCdtMapper.domainToDto(estadoCdt);
    }
}

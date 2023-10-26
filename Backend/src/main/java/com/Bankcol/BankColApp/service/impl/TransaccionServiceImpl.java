package com.Bankcol.BankColApp.service.impl;

import com.Bankcol.BankColApp.domain.Transaccion;
import com.Bankcol.BankColApp.dto.TransaccionDTO;
import com.Bankcol.BankColApp.mapper.TransaccionMapper;
import com.Bankcol.BankColApp.repository.TransaccionRepository;
import com.Bankcol.BankColApp.service.TransaccionService;
import org.springframework.stereotype.Service;

@Service
public class TransaccionServiceImpl implements TransaccionService {

    private final TransaccionRepository transaccionRepository;

    public TransaccionServiceImpl(TransaccionRepository transaccionRepository) {
        this.transaccionRepository = transaccionRepository;
    }


    @Override
    public TransaccionDTO guardarNuevaTransaccion(TransaccionDTO transaccionDTO) throws Exception {

        if (transaccionDTO == null){
            throw new Exception("El tipo de dato es nulo ");

        }

        if(transaccionDTO.getTipo()== null){
            throw new Exception("tipo vacio");
        }
        if (transaccionDTO.getMonto()== null){
            throw new Exception("Monto vacio");
        }
        if (transaccionDTO.getFecha()==null){
            throw new Exception("Fecha vacia");
        }
        if (transaccionDTO.getDescripcion()==null){
            throw new Exception("Desctripcion vacia");
        }
        if (transaccionDTO.getCuentaId()==null){
            throw new Exception("cuenta vacia");
        }
        if (transaccionDTO.getDestinatarioId()==null){
            throw new Exception("Destinatario vacio");
        }

        Transaccion transaccion = TransaccionMapper.dtoToDomain(transaccionDTO);

        transaccion = transaccionRepository.save(transaccion);

        transaccionDTO = TransaccionMapper.domainToDto(transaccion);

        return transaccionDTO;
    }
}

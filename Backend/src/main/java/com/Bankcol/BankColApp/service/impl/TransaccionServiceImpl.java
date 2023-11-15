package com.Bankcol.BankColApp.service.impl;

import com.Bankcol.BankColApp.domain.Cuenta;
import com.Bankcol.BankColApp.domain.Destinatario;
import com.Bankcol.BankColApp.domain.Transaccion;
import com.Bankcol.BankColApp.dto.TransaccionDTO;
import com.Bankcol.BankColApp.mapper.TransaccionMapper;
import com.Bankcol.BankColApp.repository.CuentaRepository;
import com.Bankcol.BankColApp.repository.DestinatarioRepository;
import com.Bankcol.BankColApp.repository.TransaccionRepository;
import com.Bankcol.BankColApp.service.TransaccionService;
import org.springframework.stereotype.Service;


import java.util.List;

import java.util.Optional;


@Service
public class TransaccionServiceImpl implements TransaccionService {

    private final TransaccionRepository transaccionRepository;
    private final CuentaRepository cuentaRepository;
    private final DestinatarioRepository destinatarioRepository;


    public TransaccionServiceImpl(TransaccionRepository transaccionRepository , CuentaRepository cuentaRepository, DestinatarioRepository destinatarioRepository) {

        this.transaccionRepository = transaccionRepository;
        this.cuentaRepository = cuentaRepository;
        this.destinatarioRepository = destinatarioRepository;
    }


    @Override
    public List<TransaccionDTO> buscarTodos() {
        return TransaccionMapper.domainToDtoList(transaccionRepository.findAll());
    }

    @Override
    public TransaccionDTO guardarNuevaTransaccion(TransaccionDTO transaccionDTO) throws Exception {

        if (transaccionDTO == null){
            throw new Exception("El tipo de dato es nulo ");

        }
        if(transaccionDTO.getTipo()== null || transaccionDTO.getTipo().trim().isEmpty()){
            throw new Exception("tipo vacio");
        }
        if (transaccionDTO.getFecha()==null){
            throw new Exception("Fecha vacia");
        }
        if (transaccionDTO.getMonto()==null || transaccionDTO.getMonto()==0){
            throw new Exception("Monto vacio");
        }
        if (transaccionDTO.getDescripcion()==null || transaccionDTO.getDescripcion().trim().isEmpty()){
            throw new Exception("Desctripcion vacia");
        }
        if (transaccionDTO.getCuentaId()==null){
            throw new Exception("cuenta vacia");
        }
        if (transaccionDTO.getDestinatarioId()==null){
            throw new Exception("Destinatario vacio");
        }

        //Se verifica que la cuenta exista
        Optional<Cuenta> cuentaOptional = cuentaRepository.findById(transaccionDTO.getCuentaId());
        if(cuentaOptional.isEmpty()){
            throw new Exception("No se puede registrar la transaccion puesto que no existe una cuenta con el número " + transaccionDTO.getCuentaId());
        }

        //Se verifica que el destinatario exista
        Optional<Destinatario> destinatarioOptional = destinatarioRepository.findById(transaccionDTO.getDestinatarioId());
        if(destinatarioOptional.isEmpty()){
            throw new Exception("No se puede registrar la transaccion puesto que no existe un destinatario con el número " + transaccionDTO.getDestinatarioId());
        }

        Transaccion transaccion = TransaccionMapper.dtoToDomain(transaccionDTO);

        transaccion = transaccionRepository.save(transaccion);

        return TransaccionMapper.domainToDto(transaccion);
    }
}

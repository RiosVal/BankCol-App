package com.BankCol.BankColApp.service.impl;

import com.BankCol.BankColApp.domain.Consignacion;
import com.BankCol.BankColApp.domain.Cuenta;
import com.BankCol.BankColApp.domain.Destinatario;
import com.BankCol.BankColApp.domain.Transaccion;
import com.BankCol.BankColApp.dto.TransaccionDTO;
import com.BankCol.BankColApp.mapper.ConsignacionMapper;
import com.BankCol.BankColApp.mapper.TransaccionMapper;
import com.BankCol.BankColApp.repository.CuentaRepository;
import com.BankCol.BankColApp.repository.DestinatarioRepository;
import com.BankCol.BankColApp.repository.TransaccionRepository;
import com.BankCol.BankColApp.service.TransaccionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransaccionServiceImpl implements TransaccionService {
    private final TransaccionRepository transaccionRepository;
    private final CuentaRepository cuentaRepository;
    private final DestinatarioRepository destinatarioRepository;

    public TransaccionServiceImpl(TransaccionRepository transaccionRepository, CuentaRepository cuentaRepository, DestinatarioRepository destinatarioRepository) {
        this.transaccionRepository = transaccionRepository;
        this.cuentaRepository = cuentaRepository;
        this.destinatarioRepository = destinatarioRepository;
    }


    @Override
    public TransaccionDTO guardarNuevaTransaccion(TransaccionDTO transaccionDTO) throws Exception {
        if(transaccionDTO == null) { throw new Exception("Transaccion nula"); }

        if(transaccionDTO.getCodigoTransaccion() == null || transaccionDTO.getCodigoTransaccion().isEmpty()) { throw new Exception("Código de transaccion vacío"); }

        if(transaccionDTO.getTipo() == null || transaccionDTO.getTipo().isEmpty()) { throw new Exception("Tipo de transaccion vacío"); }

        if(transaccionDTO.getFecha() == null) { throw new Exception("Fecha de transaccion vacía"); }

        if(transaccionDTO.getMonto() == null || transaccionDTO.getMonto() == 0) { throw new Exception("Monto de transaccion vacío"); }

        if(transaccionDTO.getDescripcion() == null || transaccionDTO.getDescripcion().isEmpty()) { throw new Exception("Descripción de transaccion vacía"); }

        if(transaccionDTO.getCuentaId() == null || transaccionDTO.getCuentaId() == 0) { throw new Exception("Cuenta de transaccion vacío o no válida"); }

        if(transaccionDTO.getDestinatarioId() == null || transaccionDTO.getDestinatarioId() == 0) { throw new Exception("Destinatario de transaccion vacío o no válida"); }

        Optional<Transaccion> transaccionOptional = transaccionRepository.findTransaccionByCodigoTransaccion(transaccionDTO.getCodigoTransaccion());
        if(transaccionOptional.isPresent()) {
            throw new Exception("Ya existe una transaccion con codigo "+ transaccionDTO.getCodigoTransaccion());
        }

        Optional<Cuenta> cuentaOptional = cuentaRepository.findById(transaccionDTO.getCuentaId());
        if(cuentaOptional.isEmpty()) {
            throw new Exception("No existe una cuenta con id " + transaccionDTO.getCuentaId());
        }

        Optional<Destinatario> destinatarioOptional = destinatarioRepository.findById(transaccionDTO.getDestinatarioId());
        if(destinatarioOptional.isEmpty()) {
            throw new Exception("No existe un destinatario con id " + transaccionDTO.getDestinatarioId());
        }

        Transaccion transaccion = TransaccionMapper.dtoToDomain(transaccionDTO);
        transaccion.setCuentaId(cuentaOptional.get());
        transaccion.setDestinatarioId(destinatarioOptional.get());

        transaccion = transaccionRepository.save(transaccion);

        return TransaccionMapper.domainToDto(transaccion);
    }

    @Override
    public List<TransaccionDTO> buscarTodos() {
        return TransaccionMapper.domainToDtoList(transaccionRepository.findAll());
    }
}

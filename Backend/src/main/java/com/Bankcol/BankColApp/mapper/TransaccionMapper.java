package com.Bankcol.BankColApp.mapper;

import com.Bankcol.BankColApp.domain.Transaccion;
import com.Bankcol.BankColApp.dto.TransaccionDTO;

import java.util.List;
/*-----------------------------------------------FALTAN LAS FOREIGN KEYS-----------------------------------------------*/
public class TransaccionMapper {
    public static Transaccion dtoToDomain(TransaccionDTO transaccionDTO) {
        return Transaccion.builder()
                .id(transaccionDTO.getId())
                .tipo(transaccionDTO.getTipo())
                .fecha(transaccionDTO.getFecha())
                .monto(transaccionDTO.getMonto())
                .descripcion(transaccionDTO.getDescripcion())
                .build();
    }

    public static TransaccionDTO domainToDto(Transaccion transaccion) {
        return TransaccionDTO.builder()
                .id(transaccion.getId())
                .tipo(transaccion.getTipo())
                .fecha(transaccion.getFecha())
                .monto(transaccion.getMonto())
                .descripcion(transaccion.getDescripcion())
                .cuentaId((transaccion.getCuenta() == null) ?
                        null : transaccion.getCuenta().getId())
                .destinatarioId((transaccion.getDestinatario() == null) ?
                        null : transaccion.getDestinatario().getId())
                .build();
    }
    public static List<Transaccion> dtoToDomainList(List<TransaccionDTO> transaccionDTOS) {
        return transaccionDTOS.stream().map(TransaccionMapper::dtoToDomain).toList();
    }

    public static  List<TransaccionDTO> domainToDtoList(List<Transaccion> transaccions) {
        return transaccions.stream().map(TransaccionMapper::domainToDto).toList();
    }
}


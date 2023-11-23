package com.BankCol.BankColApp.mapper;

import com.BankCol.BankColApp.domain.Transaccion;
import com.BankCol.BankColApp.dto.TransaccionDTO;

import java.util.List;

public class TransaccionMapper {
    public static Transaccion dtoToDomain(TransaccionDTO transaccionDTO) {
        return Transaccion.builder()
                .id(transaccionDTO.getId())
                .codigoTransaccion(transaccionDTO.getCodigoTransaccion())
                .tipo(transaccionDTO.getTipo())
                .fecha(transaccionDTO.getFecha())
                .monto(transaccionDTO.getMonto())
                .descripcion(transaccionDTO.getDescripcion())
                .build();
    }

    public static TransaccionDTO domainToDto(Transaccion transaccion){
        return TransaccionDTO.builder()
                .id(transaccion.getId())
                .codigoTransaccion(transaccion.getCodigoTransaccion())
                .tipo(transaccion.getTipo())
                .fecha(transaccion.getFecha())
                .monto(transaccion.getMonto())
                .descripcion(transaccion.getDescripcion())
                .cuentaId((transaccion.getCuentaId() == null) ?
                        null : transaccion.getCuentaId().getId())
                .destinatarioId((transaccion.getDestinatarioId() == null) ?
                        null : transaccion.getDestinatarioId().getId())
                .build();
    }

    public static List<Transaccion> dtoToDomainList(List<TransaccionDTO> transaccionDTOS) {
        return transaccionDTOS.stream().map(TransaccionMapper::dtoToDomain).toList();
    }

    public static  List<TransaccionDTO> domainToDtoList(List<Transaccion> transaccions) {
        return transaccions.stream().map(TransaccionMapper::domainToDto).toList();
    }
}

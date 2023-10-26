package com.Bankcol.BankColApp.service;

import com.Bankcol.BankColApp.dto.SucursalDTO;
import com.Bankcol.BankColApp.dto.TransaccionDTO;

public interface TransaccionService {

    TransaccionDTO guardarNuevaTransaccion(TransaccionDTO transaccionDTO) throws Exception;
}

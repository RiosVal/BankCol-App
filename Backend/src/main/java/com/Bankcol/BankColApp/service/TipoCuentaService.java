package com.Tecnicas.BancoApp.service;

import com.Tecnicas.BancoApp.domain.TipoCuenta;
import com.Tecnicas.BancoApp.dto.TipoCuentaDTO;

public interface TipoCuentaService {
    public TipoCuentaDTO guardarNuevoTipoCuenta(TipoCuentaDTO tipoCuentaDTO) throws Exception;

}

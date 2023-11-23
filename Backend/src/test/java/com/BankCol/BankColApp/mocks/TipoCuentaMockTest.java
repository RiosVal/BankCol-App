package com.BankCol.BankColApp.mocks;

import com.BankCol.BankColApp.domain.TipoCuenta;
import com.BankCol.BankColApp.dto.TipoCuentaDTO;
import com.BankCol.BankColApp.mapper.TipoCuentaMapper;

import java.util.Arrays;
import java.util.List;

public class TipoCuentaMockTest {
    public static Integer ID_UNO = 1;
    public static String DESCRIPCION_UNO = "Cuenta de Ahorros";

    public static Integer ID_DOS = 2;
    public static String DESCRIPCION_DOS = "Cuenta Corriente";

    public static TipoCuenta TIPOCUENTA_UNO =
            TipoCuenta.builder()
                    .id(ID_UNO)
                    .descripcion(DESCRIPCION_UNO)
                    .build();

    public static TipoCuenta TIPOCUENTA_DOS =
            TipoCuenta.builder()
                    .id(ID_DOS)
                    .descripcion(DESCRIPCION_DOS)
                    .build();

    public static List<TipoCuenta> TIPOS_CUENTAS_LIST = Arrays.asList(TIPOCUENTA_UNO, TIPOCUENTA_DOS);

    public static List<TipoCuentaDTO> TIPOS_CUENTAS_DTOS_LIST = TipoCuentaMapper.domainToDtoList(TIPOS_CUENTAS_LIST);
}

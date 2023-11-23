package com.BankCol.BankColApp.mocks;

import com.BankCol.BankColApp.domain.EstadoCdt;
import com.BankCol.BankColApp.dto.EstadoCdtDTO;
import com.BankCol.BankColApp.mapper.EstadoCdtMapper;

import java.util.Arrays;
import java.util.List;

public class EstadoCdtMockTest {
    public static Integer id_UNO = 1;
    public static String descripcion_UNO = "Activo";

    public static Integer id_DOS = 2;
    public static String descripcion_DOS = "Inactivo";

    public static EstadoCdt ESTADO_CDT_UNO =
            EstadoCdt.builder()
                    .id(id_UNO)
                    .descripcion(descripcion_UNO)
                    .build();

    public static EstadoCdt ESTADO_CDT_DOS =
            EstadoCdt.builder()
                    .id(id_DOS)
                    .descripcion(descripcion_DOS)
                    .build();

    public static List<EstadoCdt> ESTADOS_CDT_LIST = Arrays.asList(ESTADO_CDT_UNO, ESTADO_CDT_DOS);

    public static List<EstadoCdtDTO> ESTADOS_DTO_LIST = EstadoCdtMapper.domainToDtoList(ESTADOS_CDT_LIST);
}

package com.BankCol.BankColApp.mocks;

import com.BankCol.BankColApp.domain.Sucursal;
import com.BankCol.BankColApp.dto.SucursalDTO;
import com.BankCol.BankColApp.mapper.SucursalMapper;

import java.util.Arrays;
import java.util.List;

public class SucursalMockTest {
    public static Integer id_UNO = 1;
    public static String ciudad_UNO = "Bogotá";
    public static String direccion_UNO = "Carrera 7 # 34-56";
    public static String telefono_UNO = "+57 1 123 4567";


    public static Integer id_DOS = 2;
    public static String ciudad_DOS = "Medellín";
    public static String direccion_DOS = "Calle 45 # 67-89";
    public static String telefono_DOS = "+57 4 987 6543";

    public static Sucursal SUCURSAL_UNO =
            Sucursal.builder()
                    .id(id_UNO)
                    .ciudad(ciudad_UNO)
                    .direccion(direccion_UNO)
                    .telefono(telefono_UNO)
                    .build();

    public static Sucursal SUCURSAL_DOS =
            Sucursal.builder()
                    .id(id_DOS)
                    .ciudad(ciudad_DOS)
                    .direccion(direccion_DOS)
                    .telefono(telefono_DOS)
                    .build();

    public static List<Sucursal> SUCURSALES_LIST = Arrays.asList(SUCURSAL_UNO, SUCURSAL_DOS);

    public static List<SucursalDTO> SUCURSALES_DTO_LIST = SucursalMapper.domainToDtoList(SUCURSALES_LIST);
}

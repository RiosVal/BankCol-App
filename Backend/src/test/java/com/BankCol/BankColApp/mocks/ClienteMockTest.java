package com.BankCol.BankColApp.mocks;

import com.BankCol.BankColApp.domain.Cliente;
import com.BankCol.BankColApp.dto.ClienteDTO;
import com.BankCol.BankColApp.mapper.ClienteMapper;

import java.util.Arrays;
import java.util.List;

public class ClienteMockTest {
    public static Integer ID_UNO = 1;
    public static Integer CEDULA_UNO = 982634;
    public static String NOMBRE_UNO = "SUSANA";
    public static String APELLIDO_UNO = "GARCIA";
    public static String USUARIO_UNO = "susy_garcia9826";
    public static String CORREO_UNO = "susana@garcia.com";
    public static String CONTRA_UNO = "unSecretoImportante";


    public static Integer ID_DOS = 2;
    public static Integer CEDULA_DOS = 728173;
    public static String NOMBRE_DOS = "DANIEL";
    public static String APELLIDO_DOS = "PAREJA";
    public static String USUARIO_DOS = "daniel_pareja7281";
    public static String CORREO_DOS = "daniel@pareja.com";
    public static String CONTRA_DOS = "contraseña";


    public static Cliente CLIENTE_UNO =
            Cliente.builder()
                    .id(ID_UNO)
                    .cedula(CEDULA_UNO)
                    .nombre(NOMBRE_UNO)
                    .apellido(APELLIDO_UNO)
                    .usuario(USUARIO_UNO)
                    .correo(CORREO_UNO)
                    .contra(CONTRA_UNO)
                    .build();

    public static Cliente CLIENTE_DOS =
            Cliente.builder()
                    .id(ID_DOS)
                    .cedula(CEDULA_DOS)
                    .nombre(NOMBRE_DOS)
                    .apellido(APELLIDO_DOS)
                    .usuario(USUARIO_DOS)
                    .correo(CORREO_DOS)
                    .contra(CONTRA_DOS)
                    .build();

    public static List<Cliente> CLIENTES_LIST = Arrays.asList(CLIENTE_UNO, CLIENTE_DOS);

    public static List<ClienteDTO> CLIENTES_DTO_LIST = ClienteMapper.domainToDtoList(CLIENTES_LIST);
}

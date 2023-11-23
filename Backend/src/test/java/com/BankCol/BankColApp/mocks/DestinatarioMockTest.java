package com.BankCol.BankColApp.mocks;

import com.BankCol.BankColApp.domain.Destinatario;
import com.BankCol.BankColApp.dto.DestinatarioDTO;
import com.BankCol.BankColApp.mapper.DestinatarioMapper;

import java.util.Arrays;
import java.util.List;

public class DestinatarioMockTest {
    public static Integer id_UNO = 1;
    public static Integer numcuentaDestinatario_UNO = 987656;
    public static String bancoDestinatario_UNO = "Bancolombia";
    public static Integer cedulaDestinatario_UNO = 141414;
    public static String nombreDestinatario_UNO = "Alejandra";
    public static String apellidoDestinatario_UNO = "Restrepo";
    public static Boolean cuentaFavorita_UNO = true;


    public static Integer id_DOS = 2;
    public static Integer numcuentaDestinatario_DOS = 345676;
    public static String bancoDestinatario_DOS = "AV villas";
    public static Integer cedulaDestinatario_DOS = 464646;
    public static String nombreDestinatario_DOS = "Nicolas";
    public static String apellidoDestinatario_DOS = "Piragua";
    public static Boolean cuentaFavorita_DOS = false;


    public static Destinatario DESTINATARIO_UNO =
            Destinatario.builder()
                    .id(id_UNO)
                    .numcuentaDestinatario(numcuentaDestinatario_UNO)
                    .cedulaDestinatario(cedulaDestinatario_UNO)
                    .nombreDestinatario(nombreDestinatario_UNO)
                    .apellidoDestinatario(apellidoDestinatario_UNO)
                    .cuentaFavorita(cuentaFavorita_UNO)
                    .build();

    public static Destinatario DESTINATARIO_DOS =
            Destinatario.builder()
                    .id(id_DOS)
                    .numcuentaDestinatario(numcuentaDestinatario_DOS)
                    .cedulaDestinatario(cedulaDestinatario_DOS)
                    .nombreDestinatario(nombreDestinatario_DOS)
                    .apellidoDestinatario(apellidoDestinatario_DOS)
                    .cuentaFavorita(cuentaFavorita_DOS)
                    .build();

    public static List<Destinatario> DESTINATARIOS_LIST = Arrays.asList(DESTINATARIO_UNO, DESTINATARIO_DOS);

    public static List<DestinatarioDTO> DESTINATARIOS_DTO_LIST = DestinatarioMapper.domainToDtoList(DESTINATARIOS_LIST);
}

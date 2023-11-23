package com.BankCol.BankColApp.service;

import com.BankCol.BankColApp.dto.ClienteDTO;
import com.BankCol.BankColApp.dto.SucursalDTO;
import com.BankCol.BankColApp.mocks.ClienteMockTest;
import com.BankCol.BankColApp.mocks.SucursalMockTest;
import com.BankCol.BankColApp.repository.SucursalRepository;
import com.BankCol.BankColApp.service.impl.SucursalServieImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
@SpringBootTest
public class SucursalServiceImplTest {
    @Mock
    private SucursalRepository sucursalRepository;
    @InjectMocks
    private SucursalServieImpl sucursalService;

    @Test
    void pruebaCorrecta(){
        assertEquals(1, 1);
    }

    @Test
    void buscarTodos() {
        //Mock de la respuesta desde DB
        given(sucursalRepository.findAll())
                .willReturn(SucursalMockTest.SUCURSALES_LIST);

        // Llamado al servicio para validar
        List<SucursalDTO> sucursalesEsperadas = sucursalService.buscarTodos();

        //Verificación del resultado
        assertEquals(2, sucursalesEsperadas.size());

        assertEquals(SucursalMockTest.id_UNO, sucursalesEsperadas.get(0).getId());

    }
}

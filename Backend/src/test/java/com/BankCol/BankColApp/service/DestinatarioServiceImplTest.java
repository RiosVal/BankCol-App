package com.BankCol.BankColApp.service;

import com.BankCol.BankColApp.dto.DestinatarioDTO;
import com.BankCol.BankColApp.mocks.DestinatarioMockTest;
import com.BankCol.BankColApp.repository.DestinatarioRepository;
import com.BankCol.BankColApp.service.impl.DestinatarioServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@SpringBootTest
public class DestinatarioServiceImplTest {
    @Mock
    private DestinatarioRepository destinatarioRepository;
    @InjectMocks
    private DestinatarioServiceImpl destinatarioService;

    @Test
    void pruebaCorrecta() { assertEquals(1,1); }

    @Test
    void buscarTodos() {
        given(destinatarioRepository.findAll())
                .willReturn(DestinatarioMockTest.DESTINATARIOS_LIST);

        List<DestinatarioDTO> destinatariosEsperados = destinatarioService.buscarTodos();

        assertEquals(2, destinatariosEsperados.size());

        assertEquals(DestinatarioMockTest.id_UNO, destinatariosEsperados.get(0).getId());
    }

}

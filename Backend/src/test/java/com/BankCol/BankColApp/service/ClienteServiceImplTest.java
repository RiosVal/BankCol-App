package com.BankCol.BankColApp.service;

import com.BankCol.BankColApp.dto.ClienteDTO;
import com.BankCol.BankColApp.mocks.ClienteMockTest;
import com.BankCol.BankColApp.repository.ClienteRepository;
import com.BankCol.BankColApp.service.impl.ClienteServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@SpringBootTest
public class ClienteServiceImplTest {
    @Mock
    private ClienteRepository clienteRepository;
    @InjectMocks
    private ClienteServiceImpl clienteService;

    @Test
    void pruebaCorrecta(){
        assertEquals(1, 1);
    }

    @Test
    void buscarTodos() {
        //Mock de la respuesta desde DB
        given(clienteRepository.findAll())
                .willReturn(ClienteMockTest.CLIENTES_LIST);

        // Llamado al servicio para validar
        List<ClienteDTO> clientesEsperados = clienteService.buscarTodos();

        //Verificación del resultado
        assertEquals(2, clientesEsperados.size());

        assertEquals(ClienteMockTest.CEDULA_UNO, clientesEsperados.get(0).getCedula());

    }
}

package com.BankCol.BankColApp.service;

import com.BankCol.BankColApp.dto.EstadoCdtDTO;
import com.BankCol.BankColApp.mocks.EstadoCdtMockTest;
import com.BankCol.BankColApp.repository.EstadoCdtRepository;
import com.BankCol.BankColApp.service.impl.EstadoCdtServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@SpringBootTest
public class EstadoCdtImplTest {
    @Mock
    private EstadoCdtRepository estadoCdtRepository;
    @InjectMocks
    private EstadoCdtServiceImpl estadoCdtService;

    @Test
    void pruebaCorrecta() { assertEquals(1, 1); }

    @Test
    void buscarTodos() {
        given(estadoCdtRepository.findAll())
                .willReturn(EstadoCdtMockTest.ESTADOS_CDT_LIST);

        List<EstadoCdtDTO> estadosEsperados = estadoCdtService.buscarTodos();

        assertEquals(2, estadosEsperados.size());

        assertEquals(EstadoCdtMockTest.descripcion_UNO, estadosEsperados.get(0).getDescripcion());
    }
}

package com.BankCol.BankColApp.service;

import com.BankCol.BankColApp.dto.ClienteDTO;
import com.BankCol.BankColApp.dto.TipoCuentaDTO;
import com.BankCol.BankColApp.mocks.ClienteMockTest;
import com.BankCol.BankColApp.mocks.TipoCuentaMockTest;
import com.BankCol.BankColApp.repository.TipoCuentaRepository;
import com.BankCol.BankColApp.service.impl.TipoCuentaServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@SpringBootTest
public class TipoCuentaServiceImplTest {
    @Mock
    private TipoCuentaRepository tipoCuentaRepository;
    @InjectMocks
    private TipoCuentaServiceImpl tipoCuentaService;

    @Test
    void pruebaCorrecta(){
        assertEquals(1, 1);
    }

    @Test
    void buscarTodos() {
        //Mock de la respuesta desde DB
        given(tipoCuentaRepository.findAll())
                .willReturn(TipoCuentaMockTest.TIPOS_CUENTAS_LIST);

        // Llamado al servicio para validar
        List<TipoCuentaDTO> tiposEsperados = tipoCuentaService.buscarTodos();

        //Verificación del resultado
        assertEquals(2, tiposEsperados.size());

        assertEquals(TipoCuentaMockTest.ID_UNO, tiposEsperados.get(0).getId());

    }
}

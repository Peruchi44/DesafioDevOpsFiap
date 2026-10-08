package com.java.projetofiap.desafiodevops;

import com.java.projetofiap.desafiodevops.model.RegistroEsg;
import com.java.projetofiap.desafiodevops.repository.RegistroEsgRepository;
import com.java.projetofiap.desafiodevops.service.RegistroEsgService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RegistroEsgServiceTest {

    @Mock
    private RegistroEsgRepository repository;

    @InjectMocks
    private RegistroEsgService service;

    @Test
    void deveCalcularEmissaoAoSalvarQuandoNaoInformada() {
        RegistroEsg entrada = new RegistroEsg("TI", 100.0, null);
        when(repository.save(any(RegistroEsg.class))).thenAnswer(invocation -> invocation.getArgument(0));

        RegistroEsg resultado = service.salvar(entrada);

        assertNotNull(resultado);
        assertEquals(8.5, resultado.getEmissoesCo2Kg());
    }
}
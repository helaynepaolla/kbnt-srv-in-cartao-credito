package br.com.bradesco.kit.bff.api.v1.controller;

import br.com.bradesco.kit.bff.api.v1.model.dto.CPVResponse;
import br.com.bradesco.kit.bff.usecase.BFFCartaoCredito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ElegibilidadeControllerTest {

    @InjectMocks
    ElegibilidadeController elegibilidadeController;

    @Mock
    BFFCartaoCredito bffCartaoCredito;

    @BeforeEach
    public void setup() {
    }

    @Test
    void testVerificarElegibilidade() {
        String xStatelessOpen = "openTest";
        String xStatelessClosed = "closedTest";
        String cpfCnpj = "12345678901";
        String xClientRequestId = "123";

        CPVResponse expectedResponse = CPVResponse.builder()
                .cpv(12)
                .cpf("0323202032")
                .build();

        when(bffCartaoCredito.verificaContaExiste(cpfCnpj, xStatelessOpen, xStatelessClosed, xClientRequestId))
                .thenReturn(expectedResponse);

        CPVResponse result = elegibilidadeController.verificarElegibilidade(xStatelessOpen, xStatelessClosed, cpfCnpj, xClientRequestId);

        assertEquals(expectedResponse, result);
    }
}

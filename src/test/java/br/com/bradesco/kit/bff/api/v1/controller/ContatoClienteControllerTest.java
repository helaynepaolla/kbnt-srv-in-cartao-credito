package br.com.bradesco.kit.bff.api.v1.controller;

import br.com.bradesco.kit.bff.api.v1.model.dto.CepnResponse;
import br.com.bradesco.kit.bff.api.v1.model.dto.DadosProfissaoResponse;
import br.com.bradesco.kit.bff.usecase.BFFCartaoCredito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ContatoClienteControllerTest {

    @Mock
    private BFFCartaoCredito bffCartaoCredito;

    @InjectMocks
    private ContatoClienteController controller;

    private String cpf;

    private String cep;
    private String xStatelessOpen;
    private String xStatelessClosed;
    @BeforeEach
    public void setup() {
        cpf = "123456789";
        cep = "81230230"
;        xStatelessOpen = "xStatelessOpen";
        xStatelessClosed = "xStatelessClosed";
    }

    @Test
    public void deveRetornarOsDadosProfissionais_QuandoObterDadosProfissionaisForChamado() {
        DadosProfissaoResponse expectedResponse = new DadosProfissaoResponse();
        when(bffCartaoCredito.obterDadosProfissionais(anyString(), anyString(), anyString())).thenReturn(expectedResponse);

        DadosProfissaoResponse actualResponse = controller.obterDadosProfissionais(cpf, xStatelessOpen, xStatelessClosed);

        assertEquals(expectedResponse, actualResponse);
        verify(bffCartaoCredito).obterDadosProfissionais(anyString(), anyString(), anyString());
    }
    @Test
    public void deveRetornarOEndereco() {
        CepnResponse expectedResponse = new CepnResponse();
        when(bffCartaoCredito.obterEndereco(anyString())).thenReturn(expectedResponse);

        CepnResponse actualResponse = controller.obterEndereco(cep, xStatelessOpen, xStatelessClosed);

        assertEquals(expectedResponse, actualResponse);
        verify(bffCartaoCredito).obterEndereco(anyString());
    }
}
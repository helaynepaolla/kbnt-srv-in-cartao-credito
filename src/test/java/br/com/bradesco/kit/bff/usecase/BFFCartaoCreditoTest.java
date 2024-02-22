package br.com.bradesco.kit.bff.usecase;

import br.com.bradesco.kit.bff.api.v1.model.dto.CepnResponse;
import br.com.bradesco.kit.bff.api.v1.model.dto.DadosProfissaoResponse;
import br.com.bradesco.kit.bff.webclient.CadastroRestricoesClient;
import br.com.bradesco.kit.bff.webclient.ICepnClient;
import br.com.bradesco.kit.bff.webclient.IDadosProfissionaisClient;
import br.com.bradesco.kit.bff.webclient.ParticipanteContasSrvClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BFFCartaoCreditoTest {

    @Mock
    private ParticipanteContasSrvClient participanteContasSrvClient;

    @Mock
    private CadastroRestricoesClient cadastroRestricoesClient;

    @Mock
    private IDadosProfissionaisClient iDadosProfissionaisClient;

    @Mock
    private ICepnClient iCepnClient;

    @InjectMocks
    private BFFCartaoCredito bffCartaoCredito;

    private String cpf;
    private String cep;
    private String xStatelessOpen;
    private String xStatelessClosed;
    @BeforeEach
    public void setUp(){
        cpf = "123456789";
        cep = "81302302";
        xStatelessOpen = "xStatelessOpen";
        xStatelessClosed = "xStatelessClosed";
    }

  /*  @Test
    void verificaContaExiste_shouldReturnCPVResponse_whenContaExistsAndNoRestriction() {
        ContasResponse contasResponse = new ContasResponse();
        contasResponse.setSitCta(CONTA_ATIVA);
        when(participanteContasSrvClient.getContasResponse("mock", "mock", "mock", "mock"))
                .thenReturn(Collections.singletonList(contasResponse));

        RestricaoPessoaFisicaResponse restricoes = RestricaoPessoaFisicaResponse.builder()
                .codigo(1)
                .mensagem("Mensagem de teste")
                .restritivo(List.of(RestricaoPessoaFisicaResponse.Restritivo.builder()
                        .codTipoRestritivo(10)
                        .descTipoRestritivo("Descricao do tipo restritivo")
                        .grauRestritivo(3)
                        .quantidadeRestritivos(5)
                        .totalOcorrencias(20)
                        .build()))
                .build();


        CPVResponse response = bffCartaoCredito.verificaContaExiste("mock", "mock", "mock", "mock");
        assertNotNull(response);
        assertEquals("mock", response.getCpf());
        assertEquals(1, response.getContas().size());
        assertEquals(CONTA_ATIVA, response.getContas().get(0).getSitCta());
    }
*/
/*    @Test
    void verificaContaExiste_shouldThrowNoAccountsException_whenNoContaExists() {
        when(participanteContasSrvClient.getContasResponse("mock", "mock", "mock", "mock"))
                .thenReturn(List.of(new ContasResponse()));

        assertThrows(NoAccountsException.class, () ->
                bffCartaoCredito.verificaContaExiste("mock", "mock", "mock", "mock"));
    }*/
  @Test
  public void retornaDadosEsperados_QuandoRetornaSucesso() {
      String cpf = "12345678901";
      String xStatelessOpen = "xStatelessOpen";
      String xStatelessClosed = "xStatelessClosed";
      DadosProfissaoResponse expectedResponse = new DadosProfissaoResponse();

      when(iDadosProfissionaisClient.getDadosProfissionais(cpf, xStatelessOpen, xStatelessClosed)).thenReturn(expectedResponse);

      DadosProfissaoResponse actualResponse = bffCartaoCredito.obterDadosProfissionais(cpf, xStatelessOpen, xStatelessClosed);

      assertEquals(expectedResponse, actualResponse);
  }

    @Test
    public void retornaDadosDoCep_QuandoORetornoForSucesso() {

        CepnResponse expectedResponse = new CepnResponse();

        when(iCepnClient.getObterEndereco(cep)).thenReturn(expectedResponse);

        CepnResponse actualResponse = bffCartaoCredito.obterEndereco(cep);

        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    public void deveRetornarUmaException_QuandoHouverUmErro() {

        when(iDadosProfissionaisClient.getDadosProfissionais(cpf, xStatelessOpen, xStatelessClosed)).thenThrow(new RuntimeException());

        assertThrows(RuntimeException.class, () -> bffCartaoCredito.obterDadosProfissionais(cpf, xStatelessOpen, xStatelessClosed));
    }

    @Test
    public void deveRetornarUmaException_QuandoHouverUmErro_NaBuscaDeEndereco() {

        when( iCepnClient.getObterEndereco(cep)).thenThrow(new RuntimeException());

        assertThrows(RuntimeException.class, () -> bffCartaoCredito.obterEndereco(cep));
    }

}

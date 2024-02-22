package br.com.bradesco.kit.bff.usecase;

import br.com.bradesco.kit.bff.api.v1.model.dto.*;
import br.com.bradesco.kit.bff.constants.ConstantesNegocio;
import br.com.bradesco.kit.bff.exception.NoAccountsException;
import br.com.bradesco.kit.bff.exception.PersonIsPepException;
import br.com.bradesco.kit.bff.webclient.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BFFCartaoCredito {

    public static final String CONTENT_TYPE = "application/json";
    public static final String GRANT_TYPE = "urn:ietf:params:oauth:grant-type:jwt-bearer";
    public static final String API_KEY = "9986b168-c6cc-4fd2-883b-15fdb0684ffd";

    public static String COOKIE = "dtCookie=v_4_srv_7_sn_01FD7BF1DBAF3B14985018B2380F0F60_perc_100000_ol_0_mul_1_app-3Aea7c4b59f27d43eb_1";

    private final ParticipanteContasSrvClient participanteContasSrvClient;

    private final CadastroRestricoesClient cadastroRestricoesClient;

    private final DadosContatoClient dadosContatoClient;

    private final LoginClient loginClient;

    private final CreateJWT createJWT;

    private final AberturaProposta aberturaProposta;

    private final ProdutocardClient produtocardClient;

    private final DesignerCartaoClient designerCartaoClient;

    private final IDadosProfissionaisClient iDadosProfissionaisClient;

    private final ICepnClient iCepnClient;

    private static final String CANAL = "45";
    private static final String ORIGEM = "928";
    private static final String NUMERO_PONTO_VENDA = "3";
    private static final String TIPO_PONTO_VENDA = "1";
    private static final String OFERTA_CARTAO_URL = "https://api.ti.netd.bradescocartoes.com.br/cartoes/aquisicao/parceiros/v2/proposta/2916/oferta-produtos";


    public CPVResponse verificaContaExiste(String cpfCnpj, String xStatelessOpen, String xStatelessClosed, String xClientRequestId) {

        List<ContasResponse> contas = contasClient();
        verificaSeClienteECorrentista(contas);

        RestricaoPessoaFisicaResponse restricoes = mock();
        verificaSePessoaEPep(restricoes);

        return CPVResponse.builder()
                .cpv(restricoes.getRestritivo().get(0).getGrauRestritivo())
                .cpf(cpfCnpj)
                .contas(contas)
                // adicionar novos dados
                .build();
    }


    private void verificaSeClienteECorrentista(@NotNull List<ContasResponse> contas) {
        boolean clienteNaoECorrentista = contas.isEmpty() || contas.stream()
                .map(ContasResponse::getSitCta)
                .anyMatch(sitCta -> sitCta != null && sitCta == ConstantesNegocio.CONTA_ATIVA);
        if (!clienteNaoECorrentista) {
            throw new NoAccountsException("Cliente não é correntista.");
        }
    }

    private void verificaSePessoaEPep(RestricaoPessoaFisicaResponse restricoes) {
        boolean hasPepRestriction = restricoes.getRestritivo().stream().anyMatch(restritivo ->
                restritivo.getCodTipoRestritivo() == ConstantesNegocio.RESTRICAO_PEP_CODIGO_1 ||
                        restritivo.getCodTipoRestritivo() == ConstantesNegocio.RESTRICAO_PEP_CODIGO_2);

        if (hasPepRestriction) {
            throw new PersonIsPepException("Não é possível contratar o cartão de crédito por este canal.");
        }
    }

    private RestricaoPessoaFisicaResponse mock(){
        return RestricaoPessoaFisicaResponse.builder()
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
    }

    public DadosContatoClienteResponse dadosContatoCliente(String cpf, String xStatelessOpen, String xStatelessClosed, String tipoTelefone, String categoriaEndereco) {
        try {
            DadosMelhorContatoResponse contaResponses = dadosContatoClient.getContasResponse(xStatelessOpen, xStatelessClosed, cpf , tipoTelefone, categoriaEndereco);

            List<String> emailList = Optional.ofNullable(contaResponses)
                    .map(DadosMelhorContatoResponse::getEmails)
                    .orElse(Collections.emptyList())
                    .stream()
                    .map(DadosMelhorContatoResponse.Email::getEnderecoEletronico)
                    .collect(Collectors.toList());

            List<String> phoneNumberList = Optional.ofNullable(contaResponses)
                    .map(DadosMelhorContatoResponse::getTelefones)
                    .orElse(Collections.emptyList())
                    .stream()
                    .map(DadosMelhorContatoResponse.Telefone::getTelefone)
                    .collect(Collectors.toList());

            return DadosContatoClienteResponse.builder()
                    .emails(emailList)
                    .telefone(phoneNumberList)
                    .build();

        } catch(Exception e) {
            throw new RuntimeException("Erro ao pegar dados de contato do cliente", e);
        }
    }


    private List<ContasResponse> contasClient(){
        return List.of(new ContasResponse(123, 456, "X", 1, 321, 654, 987, 123456, 654321));

    }

    public OfertasLista cartaoDados(String cpf) throws JsonProcessingException {

       var dadosEnvioProposta = PropostaRequest.builder().canal(CANAL).origem(ORIGEM)
                .numeroPontoVenda(NUMERO_PONTO_VENDA).tipoPontoVenda(TIPO_PONTO_VENDA).cpfCnpj("46171955051").build();

        var proposta = aberturaProposta.postPropostaV2(getToken(),
                API_KEY, dadosEnvioProposta);

        var ofertasCartao = getOfertaCartao("67546286778");
        return ofertasCartao;

    }

    private String getToken(){
        var login = loginClient.loginSistema(LoginRequest.builder()
                .cvCanal(45)
                .cvOrigem(928)
                .cvTipoPontoVenda(1)
                .cvNumeroPontoVenda(3)
                .build(), GRANT_TYPE, createJWT.generateToken(), API_KEY);

        return "Bearer " +login.getToken().getAccessToken();
    }

    private OfertasLista getOfertaCartao(String cpf) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("x-brad-auth", getToken());
        headers.set("api-key", "9986b168-c6cc-4fd2-883b-15fdb0684ffd");
        headers.set("service-key", "{\"canal\":\"45\",\"origem\":\"928\",\"numeroPontoVenda\":\"3\",\"tipoPontoVenda\":\"1\",\"cpfCnpj\":\""+cpf+"\"}");
        headers.set("Cookie", "dtCookie=v_4_srv_1_sn_F34282F3BAAB12F0C1B1B7061164813C_perc_100000_ol_0_mul_1_app-3Aea7c4b59f27d43eb_1");
        headers.setContentType(MediaType.APPLICATION_JSON);

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();

        RequestEntity<MultiValueMap<String, String>> requestEntity = new RequestEntity<>(body, headers, HttpMethod.GET, URI.create("https://api.ti.netd.bradescocartoes.com.br/cartoes/aquisicao/parceiros/v2/proposta/2916/oferta-produtos"));

        var ofertas = restTemplate.exchange(requestEntity, String.class);

        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(ofertas.getBody(), OfertasLista.class);

    }

    public DadosProfissaoResponse obterDadosProfissionais(String cpf, String xStatelessOpen, String xStatelessClosed){
        try {

            return iDadosProfissionaisClient.getDadosProfissionais(cpf, xStatelessOpen, xStatelessClosed);
        }
        catch (Exception e){
            throw new RuntimeException("Erro ao pegar dados profissionais", e);
        }
    }

    public CepnResponse obterEndereco(String cep){
        try {

            return iCepnClient.getObterEndereco(cep);
        }
        catch (Exception e){
            throw new RuntimeException("Erro ao pegar dados cadastrais", e);
        }
    }
}

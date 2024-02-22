package br.com.bradesco.kit.bff.api.v1.controller;

import br.com.bradesco.kit.bff.api.v1.model.dto.CepnResponse;
import br.com.bradesco.kit.bff.api.v1.model.dto.DadosContatoClienteResponse;
import br.com.bradesco.kit.bff.api.v1.model.dto.DadosProfissaoResponse;
import br.com.bradesco.kit.bff.constants.ControllerConstants;
import br.com.bradesco.kit.bff.usecase.BFFCartaoCredito;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = ControllerConstants.V1)
@RequiredArgsConstructor
@Api
public class ContatoClienteController {

    private final BFFCartaoCredito bffCartaoCredito;

    @GetMapping(value = ControllerConstants.CONSULTA_DADOS_CONTATO_CLIENTE, produces = APPLICATION_JSON_VALUE)
    @ApiOperation(httpMethod = "GET", value = "Retorna dados de contato do cliente", produces = "application/json")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Ok")})
    public DadosContatoClienteResponse verificarElegibilidade(@RequestParam("cpfCnpj") final String cpfCnpj,
                                                              @RequestHeader("x-stateless-open") final String xStatelessOpen,
                                                              @RequestHeader("x-stateless-closed") final String xStatelessClosed,
                                                              @RequestHeader(value = "tipotelefone", defaultValue = "01") final String tipoTelefone,
                                                              @RequestHeader(value = "categoriaendereco", defaultValue = "1") final String categoriaEndereco
    ) {

        return bffCartaoCredito.dadosContatoCliente(cpfCnpj, xStatelessOpen, xStatelessClosed, tipoTelefone, categoriaEndereco);
    }

    @GetMapping(value = ControllerConstants.CONSULTA_DADOS_PROFISSIONAIS, produces = APPLICATION_JSON_VALUE)
    @ApiOperation(httpMethod = "GET", value = "Retorna dados profissionais", produces = "application/json")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Ok")})
    public DadosProfissaoResponse obterDadosProfissionais(@PathVariable final String cpf,
                                                          @RequestHeader("x-stateless-open") final String xStatelessOpen,
                                                          @RequestHeader("x-stateless-closed") final String xStatelessClosed) {
        return bffCartaoCredito.obterDadosProfissionais(cpf, xStatelessOpen, xStatelessClosed);
    }

    @GetMapping(value = ControllerConstants.OBTER_ENDERECO, produces = APPLICATION_JSON_VALUE)
    @ApiOperation(httpMethod = "GET", value = "Retorna dados cadastrais CEP", produces = "application/json")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Ok")})
    public CepnResponse obterEndereco(@PathVariable final String cep,
                                                @RequestHeader("x-stateless-open") final String xStatelessOpen,
                                                @RequestHeader("x-stateless-closed") final String xStatelessClosed) {
        return bffCartaoCredito.obterEndereco(cep);
    }
}
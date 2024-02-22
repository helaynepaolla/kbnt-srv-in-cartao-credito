package br.com.bradesco.kit.bff.api.v1.controller;

import br.com.bradesco.kit.bff.api.v1.model.dto.CPVResponse;
import br.com.bradesco.kit.bff.api.v1.model.dto.OfertaCartaoResponse;
import br.com.bradesco.kit.bff.api.v1.model.dto.OfertasLista;
import br.com.bradesco.kit.bff.constants.ControllerConstants;
import br.com.bradesco.kit.bff.usecase.BFFCartaoCredito;
import com.fasterxml.jackson.core.JsonProcessingException;
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
public class ElegibilidadeController {
    private final BFFCartaoCredito bffCartaoCredito;

    @GetMapping(value = ControllerConstants.VERIFICAR_ELEGIBILIDADE_CLIENTE, produces = APPLICATION_JSON_VALUE)
    @ApiOperation(httpMethod = "GET", value = "Verifica restrições no cpf e passa grau cpv", produces = "application/json")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Ok")})
    public CPVResponse verificarElegibilidade(@RequestHeader("x-stateless-open") final String xStatelessOpen,
                                              @RequestHeader("x-stateless-closed") final String xStatelessClosed,
                                              @RequestParam("cpfCnpj") final String cpfCnpj,
                                              @RequestHeader(value = "x-client-request-id", required = false) final String xClientRequestId){

        return bffCartaoCredito.verificaContaExiste(cpfCnpj, xStatelessOpen, xStatelessClosed, xClientRequestId);
    }


    @GetMapping("/oferta-cartoes")
    public OfertasLista opcaoCartao(String cpf) throws JsonProcessingException {
       return bffCartaoCredito.cartaoDados("19981924075");
    }
}

package br.com.bradesco.kit.bff.webclient;

import br.com.bradesco.kit.bff.api.v1.model.dto.DadosProfissaoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "${psdc.caasConsultaDadosFinanceiro.name}", url = "${psdc.caasConsultaDadosFinanceiro.url}")
public interface IDadosProfissionaisClient {
    @GetMapping(value = "/dados-financeiros-pf", produces = MediaType.APPLICATION_JSON_VALUE)
    DadosProfissaoResponse getDadosProfissionais(@RequestHeader("cpf") final String cpf,
                                                 @RequestHeader("x-stateless-open") final String xStatelessOpen,
                                                 @RequestHeader("x-stateless-closed") final String xStatelessClosed);

}

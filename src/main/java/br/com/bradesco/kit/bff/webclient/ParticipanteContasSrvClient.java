package br.com.bradesco.kit.bff.webclient;


import br.com.bradesco.kit.bff.api.v1.model.dto.ContasResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "${ctas.participanteContas.name}", url = "${ctas.participanteContas.url}")
public interface ParticipanteContasSrvClient {

    @GetMapping(value = "/api/v1/contas", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ContasResponse> getContasResponse(@RequestHeader("x-stateless-open") final String xStatelessOpen,
                                           @RequestHeader("x-stateless-closed") final String xStatelessClosed,
                                           @RequestParam("cpfCnpj") final String cpfCnpj,
                                           @RequestHeader(value = "x-client-request-id", required = false) final String xClientRequestId);
}

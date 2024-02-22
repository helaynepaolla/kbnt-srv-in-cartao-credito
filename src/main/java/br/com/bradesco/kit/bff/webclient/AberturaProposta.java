package br.com.bradesco.kit.bff.webclient;

import br.com.bradesco.kit.bff.api.v1.model.dto.ProdutoResponse;
import br.com.bradesco.kit.bff.api.v1.model.dto.PropostaRequest;
import br.com.bradesco.kit.bff.api.v1.model.dto.PropostaResponse;
import br.com.bradesco.kit.bff.config.FooConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "propostaClient", url = "https://api.ti.netd.bradescocartoes.com.br")
public interface AberturaProposta {

    @PostMapping(value = "/cartoes/aquisicao/parceiros/v2/proposta", consumes = "application/json")
    PropostaResponse postPropostaV2(
            @RequestHeader("x-brad-auth") String xBradAuth,
            @RequestHeader("api-key") String apiKey,
            //@RequestHeader("Content-Type") String contentType,
           // @RequestHeader("Cookie") String cookie,
            @RequestBody PropostaRequest propostaRequest
    );
}

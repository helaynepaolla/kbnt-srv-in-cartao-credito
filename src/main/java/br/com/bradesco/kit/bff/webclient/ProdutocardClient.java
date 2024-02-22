package br.com.bradesco.kit.bff.webclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "myClient", url = "https://api.ti.netd.bradescocartoes.com.br")
public interface ProdutocardClient {

    @RequestMapping(method = RequestMethod.GET, value = "/cartoes/aquisicao/parceiros/v2/proposta/{id}/oferta-produtos",
            consumes = "application/json")
    String getOfferProducts(@PathVariable("id") Long id,
                            @RequestHeader("service-key") String requestBody,
                            @RequestHeader("x-brad-auth") String token,
                            @RequestHeader("api-key") String apiKey,
                            @RequestHeader("Content-Type") String contentType);
}
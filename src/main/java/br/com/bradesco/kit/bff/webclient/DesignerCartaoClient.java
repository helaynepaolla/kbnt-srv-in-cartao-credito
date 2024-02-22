package br.com.bradesco.kit.bff.webclient;

import br.com.bradesco.kit.bff.api.v1.model.dto.ImagemProdutoResponse;
import br.com.bradesco.kit.bff.api.v1.model.dto.PropostaRequest;
import br.com.bradesco.kit.bff.config.FooConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "produtowdwClient", url = "https://api.ti.netd.bradescocartoes.com.br", configuration = FooConfiguration.class)
public interface DesignerCartaoClient {

    @GetMapping(value = "/cartoes/aquisicao/parceiros/v1/produto/{cdps}/img")
    String obterImagemProduto(@RequestHeader("x-brad-auth") String xBradAuth,
                                             @RequestHeader("api-key") String apiKey,
                                             @PathVariable("cdps") String cdps,
                                             @RequestHeader String requestBody);
}

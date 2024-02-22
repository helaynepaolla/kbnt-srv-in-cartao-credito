package br.com.bradesco.kit.bff.webclient;

import br.com.bradesco.kit.bff.api.v1.model.dto.CepnResponse;
import br.com.bradesco.kit.bff.config.FooConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "${psdc.cpnservice.name}", url = "${psdc.cpnservice.url}", configuration = FooConfiguration.class)

public interface ICepnClient {
    @GetMapping(value = "/api/enderecos/{cep}", produces = MediaType.APPLICATION_JSON_VALUE)
    CepnResponse getObterEndereco(@PathVariable("cep") final String cpf);
}

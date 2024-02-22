package br.com.bradesco.kit.bff.webclient;

import br.com.bradesco.kit.bff.api.v1.model.dto.LoginRequest;
import br.com.bradesco.kit.bff.api.v1.model.dto.TokenResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "loginClient", url = "https://api.ti.netd.bradescocartoes.com.br")
public interface LoginClient {
    @RequestMapping(method = RequestMethod.POST, value = "/cartoes/aquisicao/parceiros/v1/login/sistema", consumes = "application/json")
    TokenResponse loginSistema(@RequestBody LoginRequest loginRequest,
                               @RequestHeader("grant_type") String grantType,
                               @RequestHeader("assertion") String assertion,
                               @RequestHeader("api-key") String apiKey);
}

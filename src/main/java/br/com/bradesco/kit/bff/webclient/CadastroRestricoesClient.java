package br.com.bradesco.kit.bff.webclient;

import br.com.bradesco.kit.bff.api.v1.model.dto.RestricaoPessoaFisicaResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "cadastroRestricoesClient.name", url = "cadastro.restricoes.api.url")
public interface CadastroRestricoesClient {

    @GetMapping("/consulta-cadastro-restricoes/pessoafisica")
    RestricaoPessoaFisicaResponse consultaRestricoesPessoaFisica(@RequestParam("cpf") String cpf);
}

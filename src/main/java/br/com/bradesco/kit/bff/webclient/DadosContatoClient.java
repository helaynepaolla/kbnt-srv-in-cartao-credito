package br.com.bradesco.kit.bff.webclient;

import br.com.bradesco.kit.bff.api.v1.model.dto.DadosMelhorContatoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(name = "${psdc.caasConsultaDadoscontato.name}", url = "${psdc.caasConsultaDadoscontato.url}")
public interface DadosContatoClient {

    @GetMapping(value = "/dadosContato/consultar-melhor-contato", produces = MediaType.APPLICATION_JSON_VALUE)
    DadosMelhorContatoResponse getContasResponse(@RequestHeader(value = "x-stateless-open") final String xStatelessOpen,
                                                       @RequestHeader(value = "x-stateless-closed") final String xStatelessClosed,
                                                       @RequestHeader(value = "cpfCnpj", required = false) final String cpfCnpj,
                                                       @RequestHeader(value = "tipotelefone") final String tipoTelefone,
                                                       @RequestHeader(value = "categoriaendereco") final String categoriaEndereco);

}

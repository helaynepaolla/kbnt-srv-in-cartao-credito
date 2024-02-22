package br.com.bradesco.kit.bff.api.v1.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PropostaRequest {

    @JsonProperty("canal")
    private String canal;

    @JsonProperty("origem")
    private String origem;

    @JsonProperty("numeroPontoVenda")
    private String numeroPontoVenda;

    @JsonProperty("tipoPontoVenda")
    private String tipoPontoVenda;

    @JsonProperty("cpfCnpj")
    private String cpfCnpj;
}

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
public class LoginRequest {
    @JsonProperty("canal")
    private Integer cvCanal;

    @JsonProperty("origem")
    private Integer cvOrigem;

    @JsonProperty("numeroPontoVenda")
    private Integer cvNumeroPontoVenda;

    @JsonProperty("tipoPontoVenda")
    private Integer cvTipoPontoVenda;
}

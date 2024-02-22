package br.com.bradesco.kit.bff.api.v1.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class DadosProfissaoResponse {
    @JsonProperty("categoriaProfissional")
    private Integer categoriaProfissional;

    @JsonProperty("codigoProfissao")
    private Integer codigoProfissao;

    @JsonProperty("valorRendaMensal")
    private Double valorRendaMensal;

}

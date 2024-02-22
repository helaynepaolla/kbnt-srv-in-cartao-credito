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
public class PropostaResponse {

    @JsonProperty("codigoAcessoObrigatorio")
    private Object codigoAcessoObrigatorio;

    @JsonProperty("capturaFotoObrigatoria")
    private Object capturaFotoObrigatoria;

    @JsonProperty("pacDigitalObrigatoria")
    private Object pacDigitalObrigatoria;

    @JsonProperty("documentosObrigatorios")
    private Object documentosObrigatorios;

    @JsonProperty("emissaoInstataneaHabilitada")
    private Object emissaoInstataneaHabilitada;

    @JsonProperty("cadastroSenhaEmbossing")
    private Object cadastroSenhaEmbossing;

    @JsonProperty("numeroProposta")
    private Integer numeroProposta;

    @JsonProperty("camposParametrizaveis")
    private Object camposParametrizaveis;
}

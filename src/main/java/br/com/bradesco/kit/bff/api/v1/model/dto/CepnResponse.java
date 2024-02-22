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
public class CepnResponse {
    @JsonProperty("cep")
    private Integer cep;

    @JsonProperty("cepFormatado")
    private String cepFormatado;

    @JsonProperty("numeroCep")
    private Integer numeroCep;

    @JsonProperty("complementoCep")
    private Integer complementoCep;

    @JsonProperty("tipoLogradouro")
    private String tipoLogradouro;

    @JsonProperty("logradouro")
    private String logradouro;

    @JsonProperty("bairro")
    private String bairro;

    @JsonProperty("municipio")
    private String municipio;

    @JsonProperty("siglaEstado")
    private String siglaEstado;

    @JsonProperty("tipoLocalidade")
    private String tipoLocalidade;

    @JsonProperty("idMunicipioBacen")
    private Integer idMunicipioBacen;

    @JsonProperty("idEstadoBacen")
    private Integer idEstadoBacen;

    @JsonProperty("idMunicipioIbge")
    private Integer idMunicipioIbge;

    @JsonProperty("idEstadoIbge")
    private Integer idEstadoIbge;

    @JsonProperty("agenciaDepositaria")
    private Integer agenciaDepositaria;

    @JsonProperty("codigoDistribuicao")
    private Integer codigoDistribuicao;
}

package br.com.bradesco.kit.bff.api.v1.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@Builder
public class RestricaoPessoaFisicaResponse {

    private int codigo;
    private String mensagem;

    @JsonProperty("objetoRetorno")
    private List<Restritivo> restritivo;

    @Data
    @Builder
    public static class Restritivo {

        @JsonProperty("codTipoRestritivo")
        private Integer codTipoRestritivo;

        @JsonProperty("descTipoRestritivo")
        private String descTipoRestritivo;

        @JsonProperty("grauRestritivo")
        private Integer grauRestritivo;

        @JsonProperty("quantidadeRestritivos")
        private Integer quantidadeRestritivos;

        @JsonProperty("totalOcorrencias")
        private Integer totalOcorrencias;
    }
}

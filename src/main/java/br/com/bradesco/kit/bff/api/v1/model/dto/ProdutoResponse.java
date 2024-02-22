package br.com.bradesco.kit.bff.api.v1.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ProdutoResponse {

    @JsonProperty("codigoProduto")
    private String codigoProduto;

    @JsonProperty("nomeProduto")
    private String nomeProduto;

    @JsonProperty("tipoProduto")
    private int tipoProduto;

    @JsonProperty("descricaoTipoProduto")
    private String descricaoTipoProduto;

    @JsonProperty("codigoCampanha")
    private String codigoCampanha;

    @JsonProperty("rendaMinima")
    private BigDecimal rendaMinima;

    @JsonProperty("limiteMinimo")
    private BigDecimal limiteMinimo;

    @JsonProperty("limiteMaximo")
    private BigDecimal limiteMaximo;

    @JsonProperty("codigoBandeira")
    private int codigoBandeira;

    @JsonProperty("descricaoBandeira")
    private String descricaoBandeira;

    @JsonProperty("quantidadeMaximaAdicionais")
    private int quantidadeMaximaAdicionais;

    @JsonProperty("condicoes")
    private int condicoes;

    @JsonProperty("beneficiosOferta")
    private List<String> beneficiosOferta;

    @JsonProperty("beneficiosProduto")
    private List<String> beneficiosProduto;

    @JsonProperty("optins")
    private List<String> optins;

    @JsonProperty("vencimentos")
    private List<String> vencimentos;

    @JsonProperty("seguros")
    private List<String> seguros;

    @JsonProperty("anuidadeTitular")
    private BigDecimal anuidadeTitular;

    @JsonProperty("anuidadeAdicional")
    private int anuidadeAdicional;

}

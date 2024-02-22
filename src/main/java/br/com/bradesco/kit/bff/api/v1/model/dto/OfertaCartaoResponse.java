package br.com.bradesco.kit.bff.api.v1.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OfertaCartaoResponse {

        String codigoProduto;
        String nomeProduto;
        int tipoProduto;
        String descricaoTipoProduto;
        String codigoCampanha;
        double rendaMinima;
        double limiteMinimo;
        double limiteMaximo;
        int codigoBandeira;
        String descricaoBandeira;
        int quantidadeMaximaAdicionais;
        List<Object> beneficiosOferta;
        List<Object> beneficiosProduto;
        List<Object> condicoes;
        List<Object> optins;
        List<Object> vencimentos;
        List<Object> seguros;
        Object anuidadeTitular;
        Object anuidadeAdicional;
        Object valorAnuidade;
        double valorLimiteAprovadoCompra;
        double valorLimiteAprovadoSaque ;
        double valorLimiteAprovadoParcela;



}

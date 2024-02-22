package br.com.bradesco.kit.bff.api.v1.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OfertasLista {

    @JsonProperty("produtos")
    private List<OfertaCartaoResponse> offers;
    double valorLimiteAprovadoCompra;
    double valorLimiteAprovadoSaque;
    double valorLimiteAprovadoParcela;
}

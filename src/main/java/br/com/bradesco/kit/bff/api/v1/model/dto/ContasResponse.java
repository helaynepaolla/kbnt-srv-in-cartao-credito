package br.com.bradesco.kit.bff.api.v1.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ContasResponse {
    private Integer agencia;
    private Integer conta;
    private String digConta;
    private Integer sitCta;
    private Integer seqTitularClie;
    private Integer cpssoa;
    private Integer cpssoaJuridContr;
    private Integer ctpoContrNegoc;
    private Integer nseqContrNegoc;
}

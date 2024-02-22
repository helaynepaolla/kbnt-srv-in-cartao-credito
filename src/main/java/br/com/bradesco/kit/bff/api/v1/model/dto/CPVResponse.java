package br.com.bradesco.kit.bff.api.v1.model.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CPVResponse {
    private String cpf;
    private Integer cpv;
    private List<ContasResponse> contas;
}
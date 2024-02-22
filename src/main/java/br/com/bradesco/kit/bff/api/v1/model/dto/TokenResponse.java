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
public class TokenResponse {
    @JsonProperty("token")
    private Token token;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Token {
        @JsonProperty("accessToken")
        private String accessToken;
    }
}

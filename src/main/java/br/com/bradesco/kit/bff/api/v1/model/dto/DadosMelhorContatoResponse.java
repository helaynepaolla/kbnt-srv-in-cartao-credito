package br.com.bradesco.kit.bff.api.v1.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;


import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class DadosMelhorContatoResponse {

    @JsonProperty("club")
    private String club;

    @JsonProperty("emails")
    private List<Email> emails;

    @JsonProperty("telefones")
    private List<Telefone> telefones;

    @JsonProperty("enderecos")
    private List<Endereco> enderecos;

    @Data
    @Builder
    @RequiredArgsConstructor
    @AllArgsConstructor
    public static class Email {

        @JsonProperty("id")
        private int id;

        @JsonProperty("contato")
        private String contato;

        @JsonProperty("endereco_eletronico")
        private String enderecoEletronico;

        @JsonProperty("autoriza_envio_email")
        private String autorizaEnvioEmail;

        @JsonSerialize(using = LocalDateTimeSerializer.class)
        @JsonDeserialize(using = LocalDateTimeDeserializer.class)
        @JsonProperty("dataAtualizacao")
        private LocalDateTime dataAtualizacao;
    }

    @Data
    @Builder
    @RequiredArgsConstructor
    @AllArgsConstructor
    public static class Telefone {

        @JsonProperty("id")
        private int id;

        @JsonProperty("tipo")
        private String tipo;

        @JsonProperty("ddi")
        private String ddi;

        @JsonProperty("ddd")
        private String ddd;

        @JsonProperty("telefone")
        private String telefone;

        @JsonProperty("autoriza_envio_sms")
        private String autorizaEnvioSms;

        @JsonProperty("contato")
        private String contato;

        @JsonSerialize(using = LocalDateTimeSerializer.class)
        @JsonDeserialize(using = LocalDateTimeDeserializer.class)
        @JsonProperty("dataAtualizacao")
        private LocalDateTime dataAtualizacao;
    }

    @Data
    @Builder
    @RequiredArgsConstructor
    @AllArgsConstructor
    public static class Endereco {

        @JsonProperty("id")
        private int id;

        @JsonProperty("cep")
        private String cep;

        @JsonProperty("logradouro")
        private String logradouro;

        @JsonProperty("complemento")
        private String complemento;

        @JsonProperty("numero")
        private String numero;

        @JsonProperty("bairro")
        private String bairro;

        @JsonProperty("pais")
        private String pais;

        @JsonProperty("uf")
        private String uf;

        @JsonProperty("municipio")
        private String municipio;

        @JsonProperty("categoria_endereco")
        private int categoriaEndereco;

        @JsonProperty("descricao_categoria_endereco")
        private String descricaoCategoriaEndereco;

        @JsonProperty("tipo_endereco")
        private int tipoEndereco;

        @JsonProperty("descricao_tipo_endereco")
        private String descricaoTipoEndereco;

        @JsonProperty("tipo_residencia")
        private int tipoResidencia;

        @JsonProperty("descricao_tipo_residencia")
        private String descricaoTipoResidencia;

        @JsonProperty("zip_code")
        private String zipCode;

        @JsonProperty("caixa_postal")
        private int caixaPostal;

        @JsonProperty("reside_desde")
        private String resideDesde;

        @JsonSerialize(using = LocalDateTimeSerializer.class)
        @JsonDeserialize(using = LocalDateTimeDeserializer.class)
        @JsonProperty("dataAtualizacao")
        private LocalDateTime dataAtualizacao;

    }
}

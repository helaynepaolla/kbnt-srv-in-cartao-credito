package br.com.bradesco.kit.bff.constants;

public class ControllerConstants {

    private ControllerConstants() {

        throw new IllegalStateException("Utility class");

    }

    // Versions

    public static final String V1 = "/v1";

    // Endpoints

    public static final String VERIFICAR_ELEGIBILIDADE_CLIENTE = "/verificar-elegibilidade-cliente";
    public static final String CONSULTA_DADOS_CONTATO_CLIENTE = "/verificar-dados-contato";
    public static final String CONSULTA_DADOS_PROFISSIONAIS = "/dados-profissionais/{cpf}";
    public static final String OBTER_ENDERECO = "/obter-endereco/{cep}";


}
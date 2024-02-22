package br.com.bradesco.kit.bff.port.input;

import br.com.bradesco.kit.bff.api.v1.model.dto.CPVResponse;

public interface IJornadaCartaoCredito {

    CPVResponse verificaContaExiste(String cpfCnpj, String xStatelessOpen, String xStatelessClosed, String xClientRequestId);
}

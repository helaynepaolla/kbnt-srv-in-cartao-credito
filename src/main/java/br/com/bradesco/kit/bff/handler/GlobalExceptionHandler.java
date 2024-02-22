package br.com.bradesco.kit.bff.handler;

import br.com.bradesco.kit.bff.exception.BusinessException;
import br.com.bradesco.kit.bff.exception.InfrastructureException;
import br.com.bradesco.kit.bff.exception.NoAccountsException;
import br.com.bradesco.kit.bff.exception.PersonIsPepException;
import br.com.bradesco.kit.bff.model.DetalheErro;
import br.com.bradesco.kit.bff.model.ErroBffResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErroBffResponse> handleException(Exception exception) {
        DetalheErro detalheErro = new DetalheErro(HttpStatus.INTERNAL_SERVER_ERROR.toString(), exception.getMessage());
        List<DetalheErro> listaErro = new ArrayList<>();
        listaErro.add(detalheErro);
        ErroBffResponse retorno = new ErroBffResponse(HttpStatus.INTERNAL_SERVER_ERROR.toString(), exception.getMessage(), listaErro);

        LOGGER.error("Excecao de aplicação sendo lancada pelo GlobalExceptionHandler: ", exception);

        return ResponseEntity.internalServerError().body(retorno);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErroBffResponse> handleException(BusinessException exception) {
        DetalheErro detalheErro = new DetalheErro(HttpStatus.UNPROCESSABLE_ENTITY.toString(), exception.getMessage());
        List<DetalheErro> listaErro = new ArrayList<>();
        listaErro.add(detalheErro);
        ErroBffResponse retorno = new ErroBffResponse(HttpStatus.UNPROCESSABLE_ENTITY.toString(), exception.getMessage(), listaErro);

        LOGGER.error("Excecao de negocio sendo lancada pelo GlobalExceptionHandler: ", exception);

        return ResponseEntity.unprocessableEntity().body(retorno);
    }

    @ExceptionHandler(InfrastructureException.class)
    public ResponseEntity<ErroBffResponse> handleException(InfrastructureException exception) {
        DetalheErro detalheErro = new DetalheErro(HttpStatus.INTERNAL_SERVER_ERROR.toString(), exception.getMessage());
        List<DetalheErro> listaErro = new ArrayList<>();
        listaErro.add(detalheErro);
        ErroBffResponse retorno = new ErroBffResponse(HttpStatus.INTERNAL_SERVER_ERROR.toString(), exception.getMessage(), listaErro);

        LOGGER.error("Excecao de infraestrutura sendo lancada pelo GlobalExceptionHandler: ", exception);

        return ResponseEntity.internalServerError().body(retorno);
    }

    @ExceptionHandler(NoAccountsException.class)
    public ResponseEntity<ErroBffResponse> handleNoAccountsException(NoAccountsException exception) {
        DetalheErro detalheErro = new DetalheErro(String.valueOf(HttpStatus.NO_CONTENT.value()), exception.getMessage());
        List<DetalheErro> listaErro = Collections.singletonList(detalheErro);
        ErroBffResponse retorno = new ErroBffResponse(String.valueOf(HttpStatus.NO_CONTENT.value()), exception.getMessage(), listaErro);

        LOGGER.error("Erro ao recuperar contas: Não há contas cadastradas. Detalhes do erro: ", exception);

        return ResponseEntity.status(HttpStatus.NO_CONTENT.value()).body(retorno);
    }

    @ExceptionHandler(PersonIsPepException.class)
    public ResponseEntity<ErroBffResponse> handlePersonIsPepException(PersonIsPepException exception) {
        DetalheErro detalheErro = new DetalheErro(String.valueOf(HttpStatus.NO_CONTENT.value()), exception.getMessage());
        List<DetalheErro> listaErro = Collections.singletonList(detalheErro);
        ErroBffResponse retorno = new ErroBffResponse(String.valueOf(HttpStatus.NO_CONTENT.value()), exception.getMessage(), listaErro);

        LOGGER.error("Erro ao processar a solicitação: {}. Detalhes: {}", exception.getMessage(), exception);

        return ResponseEntity.status(HttpStatus.NO_CONTENT.value()).body(retorno);
    }

}

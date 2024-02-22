package br.com.bradesco.kit.bff.exception;

public class InfraOpenFeignClientException extends InfrastructureException{

    public InfraOpenFeignClientException(Throwable cause) {
        super("FEIGN-CODE", cause.getMessage(), cause);
    }

    public InfraOpenFeignClientException(String message) {
        super("FEIGN-CODE", message);
    }
}

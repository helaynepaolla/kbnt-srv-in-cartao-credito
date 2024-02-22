package br.com.bradesco.kit.bff.exception;

public class NoAccountsException extends RuntimeException {
    public NoAccountsException(String message) {
        super(message);
    }
}

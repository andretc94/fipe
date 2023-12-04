package br.com.atcarvalho.api1.exceptions;

public class NotFoundException extends RuntimeException {

    public NotFoundException() {
        super("not found");
    }
    public NotFoundException(String message) {
        super(message);
    }
}

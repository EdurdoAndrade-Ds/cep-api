package org.cep.api.exceptions;

public class CepFullErrorHandler extends RuntimeException {
    public CepFullErrorHandler() {
        super("Runtime");
    }

    public CepFullErrorHandler(String message) {
        super(message);
    }
}

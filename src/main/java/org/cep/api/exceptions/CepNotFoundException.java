package org.cep.api.exceptions;

public class CepNotFoundException extends RuntimeException {

    public CepNotFoundException() {super("Cep Nao Encontrado");}

    public CepNotFoundException(String message) {super(message);}
}

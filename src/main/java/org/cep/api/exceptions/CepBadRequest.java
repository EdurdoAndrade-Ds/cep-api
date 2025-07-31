package org.cep.api.exceptions;

public class CepBadRequest extends RuntimeException {
  public CepBadRequest() {
    super("Erro na formatacao de CEP");
  }

  public CepBadRequest(String message) {
    super(message);
  }
}

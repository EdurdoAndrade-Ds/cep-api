package org.cep.api.config;

import org.cep.api.exceptions.CepBadRequest;
import org.cep.api.exceptions.CepFullErrorHandler;
import org.cep.api.exceptions.CepNotFoundException;
import org.cep.api.infra.RestErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<Map<String,Object>> handle(ResponseStatusException ex) {

        return ResponseEntity
                .status(ex.getStatusCode())
                .body(Map.of(
                        "erro", ex.getReason(),
                        "status", ex.getStatusCode().value()
                ));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<RestErrorMessage> handleAnyException(Exception exception) {
        RestErrorMessage treatResonse = new RestErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(treatResonse);
    }

    @ExceptionHandler(CepNotFoundException.class)
    public ResponseEntity<RestErrorMessage> cepNotFound(CepNotFoundException exception) {
        RestErrorMessage treatResonse = new RestErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(treatResonse);
    }

    @ExceptionHandler(CepBadRequest.class)
    public ResponseEntity<RestErrorMessage> cepNotFound(CepBadRequest exception) {
        RestErrorMessage treatResonse = new RestErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(treatResonse);
    }

}

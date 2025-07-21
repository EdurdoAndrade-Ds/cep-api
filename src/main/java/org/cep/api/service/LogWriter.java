package org.cep.api.service;

import org.cep.api.model.CepResponse;

public interface LogWriter {
    void salvarLog(String cep, CepResponse response);
}

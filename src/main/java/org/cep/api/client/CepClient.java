package org.cep.api.client;


import org.cep.api.model.CepResponse;

public interface CepClient {
    CepResponse buscarCep(String cep);

}

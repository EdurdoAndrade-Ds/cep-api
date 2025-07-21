package org.cep.api.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.cep.api.client.CepClient;
import org.cep.api.model.CepResponse;
import org.cep.api.model.LogConsulta;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CepService {


    private final CepClient cepClient;
    private final LogWriter logWriter;

    public CepResponse buscarCep(String cep) {
        log.info("[CepService] Requisição para CEP: {}", cep);

        CepResponse response = cepClient.buscarCep(cep);
        log.info("[CepService] Resposta do client: {}", response);

        logWriter.salvarLog(cep, response);


        if (response.getErro() != null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, response.getErro());
        }

        return response;
    }
}

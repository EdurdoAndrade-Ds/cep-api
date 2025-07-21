package org.cep.api.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.cep.api.client.CepClient;
import org.cep.api.model.CepResponse;
import org.cep.api.model.LogConsulta;
import org.cep.api.repository.LogRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CepService {

    private final LogRepository logRepository;
    private final CepClient cepClient;

    public CepResponse buscarCep(String cep) {

        log.info("[CepService] Requisição para CEP: {}", cep);

        CepResponse response = cepClient.buscarCep(cep);
        log.info("[CepService] Resposta do client: {}", response);

        LogConsulta log = new LogConsulta();
        log.setCep(cep);
        log.setResposta(response);
        log.setDataConsulta(LocalDateTime.now());
        logRepository.save(log);

        if (response.getErro() != null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, response.getErro());
        }

        return response;
    }

    public List<LogConsulta> listarLogs() {
        return logRepository.findAll();
    }
}

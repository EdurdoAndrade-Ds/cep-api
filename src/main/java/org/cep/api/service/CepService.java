package org.cep.api.service;

import lombok.RequiredArgsConstructor;
import org.cep.api.client.CepClient;
import org.cep.api.model.CepResponse;
import org.cep.api.model.LogConsulta;
import org.cep.api.repository.LogRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CepService {

    private final LogRepository logRepository;
    private final CepClient cepClient;

    public CepResponse buscarCep(String cep) {

        System.out.println("[CepService] Recebi requisição para CEP: " + cep);

        CepResponse response = cepClient.buscarCep(cep);
        System.out.println("[CepService] Resposta do client: " + response);

        LogConsulta log = new LogConsulta();
        log.setCep(cep);
        log.setResposta(response);
        log.setDataConsulta(LocalDateTime.now());
        logRepository.save(log);

        return response;
    }

    public List<LogConsulta> listarLogs() {
        return logRepository.findAll();
    }
}

package org.cep.api.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.cep.api.model.CepResponse;
import org.cep.api.repository.LogRepository;
import org.cep.api.model.LogConsulta;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class LogService implements LogWriter, LogReader  {

    private final LogRepository logRepository;


    @Override
    public void salvarLog(String cep, CepResponse response) {
        LogConsulta log = new LogConsulta();
        log.setCep(cep);
        log.setResposta(response);
        log.setDataConsulta(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));
        logRepository.save(log);
    }

    @Override
    public List<LogConsulta> listarLogs() {
        return logRepository.findAll();
    }


}

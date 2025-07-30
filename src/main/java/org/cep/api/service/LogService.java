package org.cep.api.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.cep.api.dto.CepResponseDTO;
import org.cep.api.dto.LogConsultaDTO;
import org.cep.api.log.LogReader;
import org.cep.api.log.LogWriter;
import org.cep.api.mapper.CepMapper;
import org.cep.api.mapper.LogMapper;
import org.cep.api.repository.LogRepository;
import org.cep.api.model.LogConsulta;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class LogService implements LogWriter, LogReader {

    private final LogRepository logRepository;


    @Override
    public void salvarLog(String cep, CepResponseDTO dto) {
        LogConsulta log = new LogConsulta();
        log.setCep(cep);
        log.setDataConsulta(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));
        log.setResposta(CepMapper.fromDTO(dto));
        logRepository.save(log);
    }

    @Override
    public List<LogConsultaDTO> listarLogs() {
        return logRepository.findAll()
                .stream()
                .map(LogMapper::toDTO)
                .toList();
    }



}

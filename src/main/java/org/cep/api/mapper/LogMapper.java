package org.cep.api.mapper;

import org.cep.api.dto.CepResponseDTO;
import org.cep.api.dto.CreateLogRequestDTO;
import org.cep.api.dto.LogConsultaDTO;
import org.cep.api.model.CepResponse;
import org.cep.api.model.LogConsulta;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class LogMapper {

    public static LogConsultaDTO toDTO(LogConsulta log) {
        CepResponse r = log.getResposta();
        CepResponseDTO responseDTO = new CepResponseDTO(
                r.getCep(),
                r.getLogradouro(),
                r.getBairro(),
                r.getLocalidade(),
                r.getUf()
        );

        return new LogConsultaDTO(
                log.getId(),
                log.getCep(),
                log.getDataConsulta(),
                responseDTO
        );
    }

    public static LogConsulta fromDTO(CreateLogRequestDTO dto){
        LogConsulta log = new LogConsulta();
        log.setCep(dto.cep());
        log.setDataConsulta(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));

        CepResponse r = new CepResponse();
        r.setCep(dto.resposta().cep());
        r.setLogradouro(dto.resposta().logradouro());
        r.setBairro(dto.resposta().bairro());
        r.setLocalidade(dto.resposta().localidade());
        r.setUf(dto.resposta().uf());

        log.setResposta(r);

        return log;
    }
}

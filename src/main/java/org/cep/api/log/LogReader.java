package org.cep.api.log;

import org.cep.api.dto.LogConsultaDTO;

import java.util.List;

public interface LogReader {
    List<LogConsultaDTO> listarLogs();
}

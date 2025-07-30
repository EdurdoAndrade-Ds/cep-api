package org.cep.api.log;

import org.cep.api.dto.CepResponseDTO;

public interface LogWriter {
    void salvarLog(String cep, CepResponseDTO dto);
}

package org.cep.api.dto;

import java.time.LocalDateTime;

public record LogConsultaDTO(
        Long id,
        String cep,
        LocalDateTime dataConsulta,
        CepResponseDTO resposta
) {}

package org.cep.api.dto;

public record CreateLogRequestDTO(
        String cep,
        CepResponseDTO resposta
) {
}

package org.cep.api.dto;

public record CepResponseDTO(
        String cep,
        String logradouro,
        String bairro,
        String localidade,
        String uf
) {}

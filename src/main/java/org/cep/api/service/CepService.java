package org.cep.api.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.cep.api.client.CepClient;
import org.cep.api.dto.CepResponseDTO;
import org.cep.api.log.LogWriter;
import org.cep.api.mapper.CepMapper;
import org.cep.api.model.CepResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Slf4j
@Service
@RequiredArgsConstructor
public class CepService {


    private final CepClient cepClient;
    private final LogWriter logWriter;

    public CepResponseDTO buscarCep(String cep) {
        log.info("[CepService] Requisição para CEP: {}", cep);


        CepResponse response = cepClient.buscarCep(cep);
        log.info("[CepService] Resposta do client: {}", response);


        if (response.getErro() != null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, response.getErro());
        }

        CepResponseDTO dto = CepMapper.toDTO(response);
        logWriter.salvarLog(cep, dto);

        return dto;
    }
}

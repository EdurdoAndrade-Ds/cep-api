package org.cep.api.client;

import lombok.extern.slf4j.Slf4j;
import org.cep.api.model.CepResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class WireMockCepClient implements CepClient {

    private final RestTemplate restTemplate;
    private final String baseUrl;


    public WireMockCepClient(RestTemplate restTemplate, @Value("${external.cep.api.base-url}") String baseUrl) {
        this.restTemplate = restTemplate;
        this.baseUrl = baseUrl.endsWith("/") ? baseUrl : baseUrl + "/";
    }

    @Override
    public CepResponse buscarCep(String cep) {
        String url = baseUrl + cep + "/json/";

        log.info("[cepclient] Chamando {}", url);
        ResponseEntity<CepResponse> resp = restTemplate.getForEntity(url, CepResponse.class);
        return resp.getBody();

    }
}

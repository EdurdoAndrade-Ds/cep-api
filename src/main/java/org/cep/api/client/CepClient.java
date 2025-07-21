package org.cep.api.client;

import lombok.RequiredArgsConstructor;

import org.cep.api.model.CepResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class CepClient {

    private RestTemplate restTemplate = new RestTemplate();

    @Value("${external.cep.api.base-url}")
    private String baseUrl;

    public CepClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public CepResponse buscarCep(String cep) {
        String url = baseUrl + cep;
        try {
            System.out.println("[cepclient] Chamando: " + url);
            return restTemplate.getForObject(url, CepResponse.class);
        } catch (Exception e) {
            System.out.println("[CepClient] ERRO ao chamar " + url + ": " + e.getMessage());
            throw e;
        }
    }
}

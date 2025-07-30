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
        try {
            log.info("[cepclient] Chamando {}", url);
            ResponseEntity<CepResponse> resp = restTemplate.getForEntity(url, CepResponse.class);
            return resp.getBody();
        } catch (HttpClientErrorException.NotFound nf) {
            log.warn("[CepClient] CEP {} nao encontrado (404).", cep);
            return CepResponse.notFound(cep);
        } catch (HttpClientErrorException ex) {
            log.error("[CepClient] Erro HTTP {} ao chamar {}: {}", ex.getStatusCode(), url, ex.getMessage());
            throw  ex;
        } catch (Exception e) {
            log.error("[CepClient] Erro generico ao chamar {}: {}", url, e.getMessage(), e);
            throw e;
        }
    }
}

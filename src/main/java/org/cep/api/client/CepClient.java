package org.cep.api.client;

import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.cep.api.model.CepResponse;
import org.cep.api.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class CepClient {

    private RestTemplate restTemplate;
    private String baseUrl;


    public CepClient(RestTemplate restTemplate, @Value("${external.cep.api.base-url}") String baseUrl) {
        this.restTemplate = restTemplate;
        this.baseUrl = baseUrl.endsWith("/") ? baseUrl : baseUrl + "/";
    }


    public CepResponse buscarCep(String cep) {
        String url = baseUrl + cep;
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

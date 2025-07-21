package org.cep.api.controller;

import lombok.RequiredArgsConstructor;
import org.cep.api.model.CepResponse;
import org.cep.api.model.LogConsulta;
import org.cep.api.service.CepService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cep")
@RequiredArgsConstructor
public class CepController {
    private final CepService cepService;

    @GetMapping("/{cep}")
    public ResponseEntity<CepResponse> buscarCep(@PathVariable String cep) {
        return ResponseEntity.ok(cepService.buscarCep(cep));
    }

    @GetMapping("/logs")
    public ResponseEntity<List<LogConsulta>> listarLogs() {
        return ResponseEntity.ok(cepService.listarLogs());
    }

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("API de CEP esta rodando!");
    }
}

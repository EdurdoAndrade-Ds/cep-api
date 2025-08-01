package org.cep.api.controller;

import lombok.RequiredArgsConstructor;
import org.cep.api.dto.CepResponseDTO;
import org.cep.api.service.CepService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/cep/v1")
@RequiredArgsConstructor
public class CepController {
    private final CepService cepService;

    @GetMapping("/{cep}")
    public ResponseEntity<CepResponseDTO> buscarCep(@PathVariable String cep) {
        return ResponseEntity.ok(cepService.buscarCep(cep));
    }

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("API de CEP esta rodando!");
    }
}

package org.cep.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/mock/cep")
public class CepMockController {

    @GetMapping("/{cep}")
    public ResponseEntity<Map<String,Object>> mockCep(@PathVariable String cep) {
        if ("01001000".equals(cep)) {
            return ResponseEntity.ok(
                    Map.of(
                    "cep", cep,
                    "logradouro", "Praca da Luz",
                    "cidade", "Sao Paulo",
                    "uf", "sp"
                    )
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    Map.of("error", "CEP nao encontrado")
            );
        }
    }
}

package org.cep.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/mock/cep")
public class CepMockController {

    @GetMapping("/{cep}")
    public Map<String,Object> mockCep(@PathVariable String cep) {
        return Map.of(
                "cep", cep,
                "logradouro", "Praca da Luz",
                "cidade", "Sao Paulo",
                "uf", "sp"
        );
    }
}

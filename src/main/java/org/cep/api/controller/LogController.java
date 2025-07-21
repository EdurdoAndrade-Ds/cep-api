package org.cep.api.controller;


import lombok.RequiredArgsConstructor;
import org.cep.api.model.LogConsulta;
import org.cep.api.service.LogReader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/logs")
public class LogController {
    private final LogReader logReader;

    @GetMapping
    public ResponseEntity<List<LogConsulta>> listarLogs() {
        return ResponseEntity.ok(logReader.listarLogs());
    }
}

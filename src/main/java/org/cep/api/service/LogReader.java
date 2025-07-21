package org.cep.api.service;

import org.cep.api.model.LogConsulta;

import java.util.List;

public interface LogReader {
    List<LogConsulta> listarLogs();
}

package org.cep.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CepResponse {
    private String cep;
    private String bairro;
    private String logradouro;
    private String localidade;
    private String uf;
}

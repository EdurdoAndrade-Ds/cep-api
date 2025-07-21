package org.cep.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CepResponse {
    private String cep;
    private String cidade;
    private String bairro;
    private String estado;
    private String logradouro;
    private String uf;
    private String erro;

    public static CepResponse notFound(String cep) {
        CepResponse r = new CepResponse();
        r.setCep(cep);
        r.setErro("CEP nao encontrado.");
        return r;
    }
}

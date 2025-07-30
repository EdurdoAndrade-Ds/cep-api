package org.cep.api.mapper;

import org.cep.api.dto.CepResponseDTO;
import org.cep.api.model.CepResponse;

public class CepMapper {

    public static CepResponseDTO toDTO(CepResponse r) {
        return new CepResponseDTO(
                r.getCep(),
                r.getLogradouro(),
                r.getBairro(),
                r.getLocalidade(),
                r.getUf()
        );
    }

    public static CepResponse fromDTO(CepResponseDTO dto) {
        CepResponse r = new CepResponse();
        r.setCep(dto.cep());
        r.setLogradouro(dto.logradouro());
        r.setBairro(dto.bairro());
        r.setLocalidade(dto.localidade());
        r.setUf(dto.uf());
        return r;
    }
}

package org.cep.api.converter;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import org.cep.api.model.CepResponse;
    import jakarta.persistence.Converter;

@Converter(autoApply = false)
public class JpaJsonConverter implements AttributeConverter<CepResponse, String> {

    private final ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);;

    @Override
    public String convertToDatabaseColumn(CepResponse attribute) {
        try {
            return objectMapper.writeValueAsString(attribute);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao converter CepResponse para JSON", e);
        }
    }

    @Override
    public CepResponse convertToEntityAttribute(String dbData) {
        try {
            return objectMapper.readValue(dbData, CepResponse.class);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao converter JSON para CepResponse", e);
        }
    }
}

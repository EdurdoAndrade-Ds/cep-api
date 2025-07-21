package org.cep.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.cep.api.converter.JpaJsonConverter;

import java.time.LocalDateTime;

@Entity
@Table(name = "consulta_cep_tb")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogConsulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cep;

    @Convert(converter = JpaJsonConverter.class)
    private CepResponse resposta;

    private LocalDateTime dataConsulta;
}

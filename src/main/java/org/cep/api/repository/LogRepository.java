package org.cep.api.repository;

import org.cep.api.model.LogConsulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends JpaRepository<LogConsulta, Long> {

}

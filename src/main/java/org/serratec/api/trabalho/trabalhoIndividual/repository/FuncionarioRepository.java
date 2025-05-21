package org.serratec.api.trabalho.trabalhoIndividual.repository;

import org.serratec.api.trabalho.trabalhoIndividual.domain.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}

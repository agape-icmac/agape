package br.com.agape.repository;

import br.com.agape.model.Escolaridade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EscolaridadeRepository extends JpaRepository<Escolaridade, Long> {

}

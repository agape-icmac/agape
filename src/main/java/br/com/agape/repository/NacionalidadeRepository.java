package br.com.agape.repository;

import br.com.agape.model.Nacionalidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NacionalidadeRepository extends JpaRepository<Nacionalidade, Long> {

}

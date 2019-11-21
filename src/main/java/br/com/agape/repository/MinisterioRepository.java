package br.com.agape.repository;

import br.com.agape.model.Ministerio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MinisterioRepository extends JpaRepository<Ministerio, Long> {

}

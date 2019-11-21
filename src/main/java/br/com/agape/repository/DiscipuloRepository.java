package br.com.agape.repository;

import br.com.agape.model.Discipulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscipuloRepository extends JpaRepository<Discipulo, Long> {

}

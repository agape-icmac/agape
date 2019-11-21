package br.com.agape.repository;

import br.com.agape.model.Batismo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatismoRepository extends JpaRepository<Batismo, Long> {

}

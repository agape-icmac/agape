package br.com.agape.repository;

import br.com.agape.model.MetaMinisterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetaMinisterialRepository extends JpaRepository<MetaMinisterial, Long> {

}

package br.com.agape.repository;

import br.com.agape.model.CargoDiscipulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoDiscipuloRepository extends JpaRepository<CargoDiscipulo, Long> {

}

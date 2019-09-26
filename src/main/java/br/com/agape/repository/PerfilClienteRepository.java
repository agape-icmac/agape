package br.com.agape.repository;

import br.com.agape.model.PerfilCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilClienteRepository extends JpaRepository<PerfilCliente, Long> {

}
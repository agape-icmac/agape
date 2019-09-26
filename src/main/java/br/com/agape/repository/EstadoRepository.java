package br.com.agape.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.agape.model.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

}
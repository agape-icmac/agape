package br.com.agape.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.agape.model.Loja;

@Repository
public interface LojaParceiraRepository extends JpaRepository<Loja, Long> {

}
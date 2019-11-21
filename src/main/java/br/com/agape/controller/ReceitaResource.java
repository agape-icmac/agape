package br.com.agape.controller;

import br.com.agape.model.Receita;

import br.com.agape.repository.ReceitaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("receita")
public class ReceitaResource {

    @Autowired
    private ReceitaRepository receitaRepository;

    @PostMapping
    public Receita adicionar(@Valid @RequestBody Receita receita) {
        return receitaRepository.save(receita);
    }

    @GetMapping
    public List<Receita> listar() {
        return receitaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Receita> buscar(@PathVariable Long id) {
        Receita receita = receitaRepository.findById(id).orElse(null);

        if (receita == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(receita);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Receita> atualizar(@PathVariable Long id,
                                                    @Valid @RequestBody Receita receita) {

        Receita existente = receitaRepository.findById(id).orElse(null);

        if (existente == null) {
            return ResponseEntity.notFound().build();
        }

        BeanUtils.copyProperties(receita, existente, "id");

        existente = receitaRepository.save(existente);

        return ResponseEntity.ok(existente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        Receita receita = receitaRepository.findById(id).orElse(null);

        if (receita == null) {
            return ResponseEntity.notFound().build();
        }

        receitaRepository.delete(receita);

        return ResponseEntity.noContent().build();
    }

}
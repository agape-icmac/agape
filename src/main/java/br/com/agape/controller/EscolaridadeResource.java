package br.com.agape.controller;

import br.com.agape.model.Escolaridade;

import br.com.agape.repository.EscolaridadeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("escolaridade")
public class EscolaridadeResource {

    @Autowired
    private EscolaridadeRepository escolaridadeRepository;

    @PostMapping
    public Escolaridade adicionar(@Valid @RequestBody Escolaridade escolaridade) {
        return escolaridadeRepository.save(escolaridade);
    }

    @GetMapping
    public List<Escolaridade> listar() {
        return escolaridadeRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Escolaridade> buscar(@PathVariable Long id) {
        Escolaridade escolaridade = escolaridadeRepository.findById(id).orElse(null);

        if (escolaridade == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(escolaridade);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Escolaridade> atualizar(@PathVariable Long id,
                                                    @Valid @RequestBody Escolaridade escolaridade) {

        Escolaridade existente = escolaridadeRepository.findById(id).orElse(null);

        if (existente == null) {
            return ResponseEntity.notFound().build();
        }

        BeanUtils.copyProperties(escolaridade, existente, "id");

        existente = escolaridadeRepository.save(existente);

        return ResponseEntity.ok(existente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        Escolaridade escolaridade = escolaridadeRepository.findById(id).orElse(null);

        if (escolaridade == null) {
            return ResponseEntity.notFound().build();
        }

        escolaridadeRepository.delete(escolaridade);

        return ResponseEntity.noContent().build();
    }

}
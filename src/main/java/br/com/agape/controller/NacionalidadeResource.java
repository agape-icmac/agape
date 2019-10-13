package br.com.agape.controller;

import br.com.agape.model.Nacionalidade;

import br.com.agape.repository.NacionalidadeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("nacionalidade")
public class NacionalidadeResource {

    @Autowired
    private NacionalidadeRepository nacionalidadeRepository;

    @PostMapping
    public Nacionalidade adicionar(@Valid @RequestBody Nacionalidade nacionalidade) {
        return nacionalidadeRepository.save(nacionalidade);
    }

    @GetMapping
    public List<Nacionalidade> listar() {
        return nacionalidadeRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Nacionalidade> buscar(@PathVariable Long id) {
        Nacionalidade nacionalidade = nacionalidadeRepository.findById(id).orElse(null);

        if (nacionalidade == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(nacionalidade);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Nacionalidade> atualizar(@PathVariable Long id,
                                                    @Valid @RequestBody Nacionalidade nacionalidade) {

        Nacionalidade existente = nacionalidadeRepository.findById(id).orElse(null);

        if (existente == null) {
            return ResponseEntity.notFound().build();
        }

        BeanUtils.copyProperties(nacionalidade, existente, "id");

        existente = nacionalidadeRepository.save(existente);

        return ResponseEntity.ok(existente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        Nacionalidade nacionalidade = nacionalidadeRepository.findById(id).orElse(null);

        if (nacionalidade == null) {
            return ResponseEntity.notFound().build();
        }

        nacionalidadeRepository.delete(nacionalidade);

        return ResponseEntity.noContent().build();
    }

}
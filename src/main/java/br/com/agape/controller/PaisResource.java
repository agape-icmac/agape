package br.com.agape.controller;

import br.com.agape.model.Pais;

import br.com.agape.repository.PaisRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("pais")
public class PaisResource {

    @Autowired
    private PaisRepository paisRepository;

    @PostMapping
    public Pais adicionar(@Valid @RequestBody Pais pais) {
        return paisRepository.save(pais);
    }

    @GetMapping
    public List<Pais> listar() {
        return paisRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pais> buscar(@PathVariable Long id) {
        Pais pais = paisRepository.findById(id).orElse(null);

        if (pais == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(pais);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pais> atualizar(@PathVariable Long id,
                                                    @Valid @RequestBody Pais pais) {

        Pais existente = paisRepository.findById(id).orElse(null);

        if (existente == null) {
            return ResponseEntity.notFound().build();
        }

        BeanUtils.copyProperties(pais, existente, "id");

        existente = paisRepository.save(existente);

        return ResponseEntity.ok(existente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        Pais pais = paisRepository.findById(id).orElse(null);

        if (pais == null) {
            return ResponseEntity.notFound().build();
        }

        paisRepository.delete(pais);

        return ResponseEntity.noContent().build();
    }

}
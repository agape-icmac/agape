package br.com.agape.controller;

import br.com.agape.model.Ministerio;

import br.com.agape.repository.MinisterioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("ministerio")
public class MinisterioResource {

    @Autowired
    private MinisterioRepository ministerioRepository;

    @PostMapping
    public Ministerio adicionar(@Valid @RequestBody Ministerio ministerio) {
        return ministerioRepository.save(ministerio);
    }

    @GetMapping
    public List<Ministerio> listar() {
        return ministerioRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ministerio> buscar(@PathVariable Long id) {
        Ministerio ministerio = ministerioRepository.findById(id).orElse(null);

        if (ministerio == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(ministerio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ministerio> atualizar(@PathVariable Long id,
                                                    @Valid @RequestBody Ministerio ministerio) {

        Ministerio existente = ministerioRepository.findById(id).orElse(null);

        if (existente == null) {
            return ResponseEntity.notFound().build();
        }

        BeanUtils.copyProperties(ministerio, existente, "id");

        existente = ministerioRepository.save(existente);

        return ResponseEntity.ok(existente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        Ministerio ministerio = ministerioRepository.findById(id).orElse(null);

        if (ministerio == null) {
            return ResponseEntity.notFound().build();
        }

        ministerioRepository.delete(ministerio);

        return ResponseEntity.noContent().build();
    }

}
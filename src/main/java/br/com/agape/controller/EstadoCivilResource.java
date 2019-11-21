package br.com.agape.controller;

import br.com.agape.model.EstadoCivil;

import br.com.agape.repository.EstadoCivilRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("estadoCivil")
public class EstadoCivilResource {

    @Autowired
    private EstadoCivilRepository estadoCivilRepository;

    @PostMapping
    public EstadoCivil adicionar(@Valid @RequestBody EstadoCivil estadoCivil) {
        return estadoCivilRepository.save(estadoCivil);
    }

    @GetMapping
    public List<EstadoCivil> listar() {
        return estadoCivilRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadoCivil> buscar(@PathVariable Long id) {
        EstadoCivil estadoCivil = estadoCivilRepository.findById(id).orElse(null);

        if (estadoCivil == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(estadoCivil);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstadoCivil> atualizar(@PathVariable Long id,
                                                    @Valid @RequestBody EstadoCivil estadoCivil) {

        EstadoCivil existente = estadoCivilRepository.findById(id).orElse(null);

        if (existente == null) {
            return ResponseEntity.notFound().build();
        }

        BeanUtils.copyProperties(estadoCivil, existente, "id");

        existente = estadoCivilRepository.save(existente);

        return ResponseEntity.ok(existente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        EstadoCivil estadoCivil = estadoCivilRepository.findById(id).orElse(null);

        if (estadoCivil == null) {
            return ResponseEntity.notFound().build();
        }

        estadoCivilRepository.delete(estadoCivil);

        return ResponseEntity.noContent().build();
    }

}
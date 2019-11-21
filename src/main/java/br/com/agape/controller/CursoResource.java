package br.com.agape.controller;

import br.com.agape.model.Curso;
import br.com.agape.repository.CursoRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("curso")
public class CursoResource {

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    public Curso adicionar(@Valid @RequestBody Curso curso) {
        return cursoRepository.save(curso);
    }

    @GetMapping
    public List<Curso> listar() {
        return cursoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> buscar(@PathVariable Long id) {
        Curso curso = cursoRepository.findById(id).orElse(null);

        if (curso == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(curso);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> atualizar(@PathVariable Long id,
                                                    @Valid @RequestBody Curso curso) {

        Curso existente = cursoRepository.findById(id).orElse(null);

        if (existente == null) {
            return ResponseEntity.notFound().build();
        }

        BeanUtils.copyProperties(curso, existente, "id");

        existente = cursoRepository.save(existente);

        return ResponseEntity.ok(existente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        Curso curso = cursoRepository.findById(id).orElse(null);

        if (curso == null) {
            return ResponseEntity.notFound().build();
        }

        cursoRepository.delete(curso);

        return ResponseEntity.noContent().build();
    }

}
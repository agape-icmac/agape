package br.com.agape.controller;

import br.com.agape.model.Batismo;
import br.com.agape.repository.BatismoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("batismo")
public class BatismoResource {

    @Autowired
    private BatismoRepository batismoRepository;

    @PostMapping
    public Batismo adicionar(@Valid @RequestBody Batismo batismo) {
        return batismoRepository.save(batismo);
    }

    @GetMapping
    public List<Batismo> listar() {
        return batismoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Batismo> buscar(@PathVariable Long id) {
        Batismo batismo = batismoRepository.findById(id).orElse(null);

        if (batismo == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(batismo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Batismo> atualizar(@PathVariable Long id,
                                             @Valid @RequestBody Batismo batismo) {
        
        Batismo existente = batismoRepository.findById(id).orElse(null);

        if (existente == null) {
            return ResponseEntity.notFound().build();
        }

        BeanUtils.copyProperties(batismo, existente, "id");

        existente = batismoRepository.save(existente);

        return ResponseEntity.ok(existente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        Batismo batismo = batismoRepository.findById(id).orElse(null);

        if (batismo == null) {
            return ResponseEntity.notFound().build();
        }

        batismoRepository.delete(batismo);

        return ResponseEntity.noContent().build();
    }

}
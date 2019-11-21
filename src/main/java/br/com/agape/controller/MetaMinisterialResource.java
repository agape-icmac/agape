package br.com.agape.controller;

import br.com.agape.model.MetaMinisterial;

import br.com.agape.repository.MetaMinisterialRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("metaMinisterial")
public class MetaMinisterialResource {

    @Autowired
    private MetaMinisterialRepository metaMinisterialRepository;

    @PostMapping
    public MetaMinisterial adicionar(@Valid @RequestBody MetaMinisterial metaMinisterial) {
        return metaMinisterialRepository.save(metaMinisterial);
    }

    @GetMapping
    public List<MetaMinisterial> listar() {
        return metaMinisterialRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MetaMinisterial> buscar(@PathVariable Long id) {
        MetaMinisterial metaMinisterial = metaMinisterialRepository.findById(id).orElse(null);

        if (metaMinisterial == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(metaMinisterial);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MetaMinisterial> atualizar(@PathVariable Long id,
                                                    @Valid @RequestBody MetaMinisterial metaMinisterial) {

        MetaMinisterial existente = metaMinisterialRepository.findById(id).orElse(null);

        if (existente == null) {
            return ResponseEntity.notFound().build();
        }

        BeanUtils.copyProperties(metaMinisterial, existente, "id");

        existente = metaMinisterialRepository.save(existente);

        return ResponseEntity.ok(existente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        MetaMinisterial metaMinisterial = metaMinisterialRepository.findById(id).orElse(null);

        if (metaMinisterial == null) {
            return ResponseEntity.notFound().build();
        }

        metaMinisterialRepository.delete(metaMinisterial);

        return ResponseEntity.noContent().build();
    }

}
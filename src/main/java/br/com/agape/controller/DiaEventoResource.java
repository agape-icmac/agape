package br.com.agape.controller;

import br.com.agape.model.DiaEvento;
import br.com.agape.repository.DiaEventoRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("diaEvento")
public class DiaEventoResource {

    @Autowired
    private DiaEventoRepository diaEventoRepository;

    @PostMapping
    public DiaEvento adicionar(@Valid @RequestBody DiaEvento diaEvento) {
        return diaEventoRepository.save(diaEvento);
    }

    @GetMapping
    public List<DiaEvento> listar() {
        return diaEventoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiaEvento> buscar(@PathVariable Long id) {
        DiaEvento diaEvento = diaEventoRepository.findById(id).orElse(null);

        if (diaEvento == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(diaEvento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DiaEvento> atualizar(@PathVariable Long id,
                                                    @Valid @RequestBody DiaEvento diaEvento) {

        DiaEvento existente = diaEventoRepository.findById(id).orElse(null);

        if (existente == null) {
            return ResponseEntity.notFound().build();
        }

        BeanUtils.copyProperties(diaEvento, existente, "id");

        existente = diaEventoRepository.save(existente);

        return ResponseEntity.ok(existente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        DiaEvento diaEvento = diaEventoRepository.findById(id).orElse(null);

        if (diaEvento == null) {
            return ResponseEntity.notFound().build();
        }

        diaEventoRepository.delete(diaEvento);

        return ResponseEntity.noContent().build();
    }

}
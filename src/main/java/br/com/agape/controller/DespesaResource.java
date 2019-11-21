package br.com.agape.controller;

import br.com.agape.model.Despesa;
import br.com.agape.repository.DespesaRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("despesa")
public class DespesaResource {

    @Autowired
    private DespesaRepository despesaRepository;

    @PostMapping
    public Despesa adicionar(@Valid @RequestBody Despesa despesa) {
        return despesaRepository.save(despesa);
    }

    @GetMapping
    public List<Despesa> listar() {
        return despesaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Despesa> buscar(@PathVariable Long id) {
        Despesa despesa = despesaRepository.findById(id).orElse(null);

        if (despesa == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(despesa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Despesa> atualizar(@PathVariable Long id,
                                                    @Valid @RequestBody Despesa despesa) {

        Despesa existente = despesaRepository.findById(id).orElse(null);

        if (existente == null) {
            return ResponseEntity.notFound().build();
        }

        BeanUtils.copyProperties(despesa, existente, "id");

        existente = despesaRepository.save(existente);

        return ResponseEntity.ok(existente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        Despesa despesa = despesaRepository.findById(id).orElse(null);

        if (despesa == null) {
            return ResponseEntity.notFound().build();
        }

        despesaRepository.delete(despesa);

        return ResponseEntity.noContent().build();
    }

}
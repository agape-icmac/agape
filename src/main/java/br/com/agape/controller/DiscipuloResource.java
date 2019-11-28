package br.com.agape.controller;

import br.com.agape.model.Discipulo;
import br.com.agape.repository.DiscipuloRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "discipulo")
public class DiscipuloResource {

    @Autowired
    private DiscipuloRepository discipuloRepository;

    @PostMapping
    public Discipulo adicionar(@Valid @RequestBody Discipulo discipulo) {
        return discipuloRepository.save(discipulo);
    }

    @GetMapping
    public List<Discipulo> listar() {
        return discipuloRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Discipulo> buscar(@PathVariable String cpf) {
        Discipulo discipulo = discipuloRepository.findByCpf(cpf);

        if (discipulo == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(discipulo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Discipulo> atualizar(@PathVariable Long id,
                                                    @Valid @RequestBody Discipulo discipulo) {

        Discipulo existente = discipuloRepository.findById(id).orElse(null);

        if (existente == null) {
            return ResponseEntity.notFound().build();
        }

        BeanUtils.copyProperties(discipulo, existente, "id");

        existente = discipuloRepository.save(existente);

        return ResponseEntity.ok(existente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable String cpf) {
        Discipulo discipulo = discipuloRepository.findByCpf(cpf);

        if (discipulo == null) {
            return ResponseEntity.notFound().build();
        }

        discipuloRepository.delete(discipulo);

        return ResponseEntity.noContent().build();
    }

}
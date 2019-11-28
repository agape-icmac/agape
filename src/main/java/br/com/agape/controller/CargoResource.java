package br.com.agape.controller;

import br.com.agape.model.Cargo;
import br.com.agape.repository.CargoRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("cargoDiscipulo")
public class CargoResource {

    @Autowired
    private CargoRepository cargoRepository;

    @PostMapping
    public Cargo adicionar(@Valid @RequestBody Cargo cargo) {
        return cargoRepository.save(cargo);
    }

    @GetMapping
    public List<Cargo> listar() {
        return cargoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cargo> buscar(@PathVariable Long id) {
        Cargo cargo = cargoRepository.findById(id).orElse(null);

        if (cargo == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(cargo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cargo> atualizar(@PathVariable Long id,
                                           @Valid @RequestBody Cargo cargo) {

        Cargo existente = cargoRepository.findById(id).orElse(null);

        if (existente == null) {
            return ResponseEntity.notFound().build();
        }

        BeanUtils.copyProperties(cargo, existente, "id");

        existente = cargoRepository.save(existente);

        return ResponseEntity.ok(existente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        Cargo cargo = cargoRepository.findById(id).orElse(null);

        if (cargo == null) {
            return ResponseEntity.notFound().build();
        }

        cargoRepository.delete(cargo);

        return ResponseEntity.noContent().build();
    }

}
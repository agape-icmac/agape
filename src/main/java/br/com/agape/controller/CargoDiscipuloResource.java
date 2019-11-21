package br.com.agape.controller;

import br.com.agape.model.CargoDiscipulo;
import br.com.agape.repository.CargoDiscipuloRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("cargoDiscipulo")
public class CargoDiscipuloResource {

    @Autowired
    private CargoDiscipuloRepository cargoDiscipuloRepository;

    @PostMapping
    public CargoDiscipulo adicionar(@Valid @RequestBody CargoDiscipulo cargoDiscipulo) {
        return cargoDiscipuloRepository.save(cargoDiscipulo);
    }

    @GetMapping
    public List<CargoDiscipulo> listar() {
        return cargoDiscipuloRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CargoDiscipulo> buscar(@PathVariable Long id) {
        CargoDiscipulo cargoDiscipulo = cargoDiscipuloRepository.findById(id).orElse(null);

        if (cargoDiscipulo == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(cargoDiscipulo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CargoDiscipulo> atualizar(@PathVariable Long id,
                                             @Valid @RequestBody CargoDiscipulo cargoDiscipulo) {

        CargoDiscipulo existente = cargoDiscipuloRepository.findById(id).orElse(null);

        if (existente == null) {
            return ResponseEntity.notFound().build();
        }

        BeanUtils.copyProperties(cargoDiscipulo, existente, "id");

        existente = cargoDiscipuloRepository.save(existente);

        return ResponseEntity.ok(existente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        CargoDiscipulo cargoDiscipulo = cargoDiscipuloRepository.findById(id).orElse(null);

        if (cargoDiscipulo == null) {
            return ResponseEntity.notFound().build();
        }

        cargoDiscipuloRepository.delete(cargoDiscipulo);

        return ResponseEntity.noContent().build();
    }

}
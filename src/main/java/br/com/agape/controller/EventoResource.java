package br.com.agape.controller;

import br.com.agape.model.Evento;

import br.com.agape.repository.EventoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("evento")
public class EventoResource {

    @Autowired
    private EventoRepository eventoRepository;

    @PostMapping
    public Evento adicionar(@Valid @RequestBody Evento evento) {
        return eventoRepository.save(evento);
    }

    @GetMapping
    public List<Evento> listar() {
        return eventoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evento> buscar(@PathVariable Long id) {
        Evento evento = eventoRepository.findById(id).orElse(null);

        if (evento == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(evento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Evento> atualizar(@PathVariable Long id,
                                                    @Valid @RequestBody Evento evento) {

        Evento existente = eventoRepository.findById(id).orElse(null);

        if (existente == null) {
            return ResponseEntity.notFound().build();
        }

        BeanUtils.copyProperties(evento, existente, "id");

        existente = eventoRepository.save(existente);

        return ResponseEntity.ok(existente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        Evento evento = eventoRepository.findById(id).orElse(null);

        if (evento == null) {
            return ResponseEntity.notFound().build();
        }

        eventoRepository.delete(evento);

        return ResponseEntity.noContent().build();
    }

}
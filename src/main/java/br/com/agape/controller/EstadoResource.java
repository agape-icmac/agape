package br.com.agape.controller;

import java.util.List;

import javax.validation.Valid;

import br.com.agape.repository.EstadoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estado")
public class EstadoResource {

    @Autowired
    private EstadoRepository estadoRepository;

    @PostMapping
    public Estado adicionar(@Valid @RequestBody Estado estado) {
        return estadoRepository.save(estado);
    }

    @GetMapping
    public List<Estado> listar() {
        return estadoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estado> buscar(@PathVariable Long id) {
        Estado estado = estadoRepository.findById(id).orElse(null);

        if (estado == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(estado);
    }

    @PutMapping("/{id}")
	public ResponseEntity<Estado> atualizar(@PathVariable Long id, 
		@Valid @RequestBody Estado estado) {
            Estado existente = estadoRepository.findById(id).orElse(null);
		
            if (existente == null) {
                return ResponseEntity.notFound().build();
            }
		
            BeanUtils.copyProperties(estado, existente, "id");
            
            existente = estadoRepository.save(existente);
            
            return ResponseEntity.ok(existente);
    }
    
    @DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		Estado estado = estadoRepository.findById(id).orElse(null);
		
		if (estado == null) {
			return ResponseEntity.notFound().build();
		}
		
		estadoRepository.delete(estado);
		
        return ResponseEntity.noContent().build();
    }
}
package br.com.agape.controller;

import java.util.List;

import javax.validation.Valid;

import br.com.agape.repository.CategoriaUsuarioRepository;
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

import br.com.agape.model.CategoriaUsuario;

@RestController
@RequestMapping("/categoriaUsuario")
public class CategoriaUsuarioResource {

    @Autowired
    private CategoriaUsuarioRepository categoriaUsuarioRepository;

    @PostMapping
    public CategoriaUsuario adicionar(@Valid @RequestBody CategoriaUsuario categoria) {
        return categoriaUsuarioRepository.save(categoria);
    }

    @GetMapping
    public List<CategoriaUsuario> listar() {
        return categoriaUsuarioRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaUsuario> buscar(@PathVariable Long id) {
        CategoriaUsuario categoria = categoriaUsuarioRepository.findById(id).orElse(null);

        if (categoria == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(categoria);
    }

    @PutMapping("/{id}")
	public ResponseEntity<CategoriaUsuario> atualizar(@PathVariable Long id,
		@Valid @RequestBody CategoriaUsuario categoria) {
            CategoriaUsuario existente = categoriaUsuarioRepository.findById(id).orElse(null);

            if (existente == null) {
                return ResponseEntity.notFound().build();
            }

            BeanUtils.copyProperties(categoria, existente, "id");

            existente = categoriaUsuarioRepository.save(existente);

            return ResponseEntity.ok(existente);
    }

    @DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		CategoriaUsuario categoria = categoriaUsuarioRepository.findById(id).orElse(null);

		if (categoria == null) {
			return ResponseEntity.notFound().build();
		}

		categoriaUsuarioRepository.delete(categoria);
		
        return ResponseEntity.noContent().build();
    }
}
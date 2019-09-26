package br.com.agape.controller;

import java.util.List;

import javax.validation.Valid;

import br.com.agape.repository.UsuarioRepository;
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

import br.com.agape.model.Usuario;

@RestController
@RequestMapping("/usuario")
public class UsuarioResource {

    @Autowired
    private UsuarioRepository usuarioRepositorio;

    @PostMapping
    public Usuario adicionar(@Valid @RequestBody Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }

    @GetMapping
    public List<Usuario> listar() {
        return usuarioRepositorio.findAll();
    }

    @GetMapping("/{email}")
    public ResponseEntity<Usuario> buscar(@PathVariable String email) {
        Usuario usuario = usuarioRepositorio.findByEmail(email);

        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(usuario);
    }

    @PutMapping("/{email}")
	public ResponseEntity<Usuario> atualizar(@PathVariable String email,
		@Valid @RequestBody Usuario usuario) {
            Usuario existente = usuarioRepositorio.findByEmail(email);
		
            if (existente == null) {
                return ResponseEntity.notFound().build();
            }
		
            BeanUtils.copyProperties(usuario, existente, "id");
            
            existente = usuarioRepositorio.save(existente);
            
            return ResponseEntity.ok(existente);
    }
    
    @DeleteMapping("/{email}")
	public ResponseEntity<Void> remover(@PathVariable String email) {
		Usuario usuario = usuarioRepositorio.findByEmail(email);

		if (usuario == null) {
			return ResponseEntity.notFound().build();
		}
		
		usuarioRepositorio.delete(usuario);
		
        return ResponseEntity.noContent().build();
    }

}
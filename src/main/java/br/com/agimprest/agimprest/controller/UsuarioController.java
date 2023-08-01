package br.com.agimprest.agimprest.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.agimprest.agimprest.UsuarioDTO;
import br.com.agimprest.agimprest.model.Usuario;
import br.com.agimprest.agimprest.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuari o")
public class UsuarioController {

	private final UsuarioService usuarioService;

	@PostMapping
	@ResponseBody
	public ResponseEntity<Usuario> salvar(@Valid UsuarioDTO dto, UriComponentsBuilder builder) {
		Usuario usuario = dto.from();
		Usuario saved = usuarioService.save(usuario);
		UriComponents uriComponents = builder.path("/usuario/{id}").buildAndExpand(saved.getId());
		return ResponseEntity.created(builder.build().toUri()).body(saved);
	}

	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Usuario> findById(@PathVariable Long id) {
		return ResponseEntity.ok(usuarioService.findById(id));
	}

	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Usuario>> findAll() {
		return ResponseEntity.ok(usuarioService.findAll());
	}
	
	@PutMapping
	@ResponseBody
	public ResponseEntity<Void> update(@Valid Usuario usuario){
		usuarioService.update(usuario);
		return ResponseEntity.ok().build();
	}
}

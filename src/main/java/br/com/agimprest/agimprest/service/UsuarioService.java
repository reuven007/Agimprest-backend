package br.com.agimprest.agimprest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.agimprest.agimprest.model.Usuario;
import br.com.agimprest.agimprest.repository.UsuarioRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {
	
	private final UsuarioRepository usuarioRepository;
	
	public Usuario save(@NotNull final Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	public Usuario findById(Long id) {
		return usuarioRepository.findById(id).orElse(new Usuario());
	}

	public void update(Usuario from) {
		usuarioRepository.save(from);
	}

}

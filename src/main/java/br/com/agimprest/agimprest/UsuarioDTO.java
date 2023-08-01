package br.com.agimprest.agimprest;

import br.com.agimprest.agimprest.model.Usuario;
import jakarta.validation.constraints.NotNull;

public record UsuarioDTO(@NotNull(message = "Email nao pode ser nulo.")String email, @NotNull(message = "Senha nao pode ser nula.") String senha,
		@NotNull(message = "Categoria nao pode ser vazia") String categoria) {

	public Usuario from() {
		Usuario usuario = new Usuario();
		usuario.setEmail(this.email);
		usuario.setSenha(this.senha);
		usuario.setCategoria(this.categoria);
		return usuario;
	}
	
}

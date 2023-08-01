package br.com.agimprest.agimprest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_usuario")
public class Usuario {

	@Id
	@GeneratedValue
	private Long id;
	private String email;
	private String senha;
	private String categoria;

}

package br.com.sisgr.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue
	private Long id;

	@NotNull(message = "usuario.cadastro.nome.obrigatorio")
	private String nome;
	
	private String sobrenome;

	@NotNull(message = "{usuario.cadastro.nome.obrigatorio}")
	@Size(min = 3, max = 10, message = "{usuario.cadastro.login.tamanho}")
	private String login;

	@NotNull(message = "{usuario.cadastro.senha.obrigatorio}")
	@Size(min = 3, max = 10, message = "{usuario.cadastro.senha.tamanho}")
	private String senha;

	@NotNull(message = "usuario.cadastro.email.obrigatorio")
	private String email;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

}

package br.com.sisgr.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "usuario")
public class Usuario extends Pessoa{

	@NotNull(message = "{usuario.cadastro.senha.obrigatorio}")
	@Size(min = 3, max = 10, message = "{usuario.cadastro.senha.tamanho}")
	private String senha;

	@OneToMany
	private List<Contato> contatos;
	
	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}

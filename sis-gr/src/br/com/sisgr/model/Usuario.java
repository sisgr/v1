package br.com.sisgr.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="usuario")
public class Usuario {
        
        @Id
        @GeneratedValue
        private Long id;
        private String nome;
        private String sobrenome;
        private String login;
        private String senha;
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

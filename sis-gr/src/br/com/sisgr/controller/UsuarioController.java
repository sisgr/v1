package br.com.sisgr.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.sisgr.dao.UsuarioDAO;
import br.com.sisgr.model.Usuario;

@Controller
public class UsuarioController {

	private UsuarioDAO dao;

	@Autowired
	public UsuarioController(UsuarioDAO usuarioDAO) {
		this.dao = usuarioDAO;
	}

	@RequestMapping("/cadastro")
	public String mostrarForm() {
		return "usuario/cadastro";
	}
	
	@RequestMapping("formLogin")
	public String mostraFormLogin(){
		return "usuario/login";
	}

	@RequestMapping("/adicionaUsuario")
public String adicionar(@Valid Usuario usuario, BindingResult result,  HttpSession session) {
		
		if(result.hasErrors()){
			System.out.println("executou");
			
			return "redirect:/cadastro";
		}
		
		
		boolean rs = dao.adicionar(usuario);
		
		if (rs != false) 
			session.setAttribute("usuarioLogado", usuario);			
		
		return "usuario/sucesso";
	}

	@RequestMapping("/sair")
	public String efetuaLogout(Usuario usuario, HttpSession session) {
		session.invalidate();
		return "redirect:/inicio";
	}
	
	@RequestMapping("/logar")
	public String efetuaLogin(Usuario usuario, HttpSession session){
		
		if (dao.existeUsuario(usuario) != false) {
			session.setAttribute("usuarioLogado",usuario);
			return "";
		}
			return "redirect:/cadastro";
	}
	
	

	

}

package br.com.sisgr.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.sisgr.dao.UsuarioDAOHibernate;
import br.com.sisgr.model.Usuario;

@Controller
public class UsuarioController {

	private UsuarioDAOHibernate dao;

	@Autowired
	public UsuarioController(UsuarioDAOHibernate usuarioDAO) {
		this.dao = usuarioDAO;
	}

	@RequestMapping("/cadastro")
	public String mostrarForm() {
		return "usuario/cadastro";
	}

	@RequestMapping("/adicionaUsuario")
	public ModelAndView adicionar(Usuario usuario) {
		dao.adicionar(usuario);
		ModelAndView mv = new ModelAndView("usuario/sucesso");
		mv.addObject("usuario", usuario);
		return mv;
	}

	@RequestMapping("/sair")
	public String efetuaLogout(Usuario usuario, HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping("/logar")
	public String efetuaLogin(Usuario usuario, HttpSession session){
		
		if (dao.buscar(usuario) != null) {
			session.setAttribute("usuarioLogado",usuario);
			return "agenda/agenda";
		}
			return "redirect:/"; 
	}

}

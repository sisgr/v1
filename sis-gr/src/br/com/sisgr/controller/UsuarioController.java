package br.com.sisgr.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@RequestMapping("/formLogin")
	public String mostraFormLogin(){
		return "usuario/login";
	}

	@RequestMapping(value = "/cadastro", method = RequestMethod.GET)
	public String mostrarForm(ModelMap model) {
		Usuario usuario = new Usuario();
		model.addAttribute("Cadastro", usuario);
		return "usuario/cadastro";
	}
	
	@RequestMapping(value = "/cadastro", method = RequestMethod.POST)
	public String adicionar(
			@ModelAttribute(value = "Cadastro") @Valid Usuario usuario,
			BindingResult result, HttpSession session) {
		if (result.hasErrors()) {
			return "usuario/cadastro";
		}
		if (dao.buscarById(usuario.getId()) != null){
			dao.editar(usuario);
			session.setAttribute("usuarioLogado", usuario);
			return "agenda/agenda";
		}
		if (dao.existeUsuario(usuario) == false){
		boolean rs = dao.adicionar(usuario);
		if (rs != false)
			session.setAttribute("usuarioLogado", usuario);

		return "usuario/sucesso";}
		return "usuario/cadastro";
	}
	
	@RequestMapping(value = "/editar", method = RequestMethod.GET)
	public String mostrarForm(@RequestParam("Cadastro") Integer id, Model model) {
		Usuario usuario = new Usuario();
		usuario = dao.buscarById(id);
		model.addAttribute("editar", usuario);
		return "usuario/cadastro";
	}
	
	@RequestMapping("/sair")
	public String efetuaLogout(Usuario usuario, HttpSession session) {
		session.invalidate();
		return "redirect:/inicio";
	}
	
	@RequestMapping("/logar")
	public String efetuaLogin(Usuario usuario, HttpSession session){
		usuario = dao.buscarByEmail(usuario);
		if (dao.existeUsuario(usuario) != false){
			session.setAttribute("usuarioLogado", usuario);

			return "agenda/agenda";}
			return "usuario/cadastro";
	}
	

}

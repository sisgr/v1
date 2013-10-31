package br.com.sisgr.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.sisgr.dao.ContatoDAO;
import br.com.sisgr.model.Contato;
import br.com.sisgr.model.Usuario;

@Controller
@RequestMapping("/contato")
public class ContatoController {

	private ContatoDAO dao;

	@Autowired
	public ContatoController(ContatoDAO contatoDAO) {
		this.dao = contatoDAO;
	}

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String listar(Model model, HttpSession session) {
		Contato contato = new Contato();
		model.addAttribute("contato", contato);
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		List<Contato> contatos = dao.listarContatos(usuario.getId());
		model.addAttribute("contatos", contatos);
		return "contato/contato";
	}

	@RequestMapping(value = "/adicionar", method = RequestMethod.POST)
	public String adicionar(@ModelAttribute(value = "editar") Contato contato,
			Model model, HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		contato.setUsuario(usuario);
		if (dao.buscarPorId(contato.getId()) != null) {
			dao.editar(contato);
		} else {
			dao.adicionar(contato);
		}
		model.addAttribute("contato", contato);
		return "redirect:/contato/listar";
	}

	@RequestMapping(value = "/deletar", method = RequestMethod.GET)
	public String deletar(@RequestParam("id") Integer id) {
		dao.remover(id);

		return "redirect:/contato/listar";
	}

	@RequestMapping(value = "/editar", method = RequestMethod.GET)
	public String formEditar(@RequestParam("editar") Integer id, Model model,
			HttpSession session) {
		Contato editar = dao.buscarPorId(id);
		model.addAttribute("editar", editar);
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		editar.setUsuario(usuario);
		List<Contato> contatos = dao.listarContatos(usuario.getId());
		model.addAttribute("contatos", contatos);

		return "contato/contato";
	}

}
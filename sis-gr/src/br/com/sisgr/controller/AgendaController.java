package br.com.sisgr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.sisgr.dao.ReuniaoDAO;

@Controller
public class AgendaController {

	private ReuniaoDAO dao;
	
	@Autowired
	public AgendaController(ReuniaoDAO reuniaoDAO){
		this.dao = reuniaoDAO;
	}
	
	@RequestMapping(value = "/agenda")
	public String mostrarAgenda(){
		return "agenda/agenda";
	}
	
	
	
}

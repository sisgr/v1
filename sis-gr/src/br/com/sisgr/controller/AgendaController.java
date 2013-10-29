package br.com.sisgr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AgendaController {

	@RequestMapping("/agenda")
	public String mostraAgenda(){
		return "agenda/agenda";
	}
	
}

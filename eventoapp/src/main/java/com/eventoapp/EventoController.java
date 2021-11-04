package com.eventoapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.eventoapp.models.Evento;
import com.eventoapp.service.EventoService;

@Controller
public class EventoController {

	@Autowired
	private EventoService se;

	@RequestMapping(value = "/cadastrarEvento", method = RequestMethod.GET)
	public String form() {
		return "evento/formEvento";
	}

	@RequestMapping(value = "/cadastrarEvento", method = RequestMethod.POST)
	public String form(Evento evento) {
		System.out.println(evento);
		se.salvar(evento);

		return "redirect:/cadastrarEvento";
	}

	@RequestMapping("/eventos")
	public ModelAndView listaEventos() {
		ModelAndView mv = new ModelAndView("evento/index");
		Iterable<Evento> eventos = se.procurarTodos();
		mv.addObject("eventos", eventos);
		return mv;
	}

	@RequestMapping(value = "/busca", method = RequestMethod.GET)
	public String form1() {

		return "evento/busca";
	}

	@RequestMapping(value = "/busca/{namebusca}", method = RequestMethod.GET)
	public ModelAndView buscaEvento(@PathVariable("namebusca") String nome) {
		ModelAndView mv = new ModelAndView("evento/busca");
		Iterable<Evento> eventos = se.procurarName(nome);
		mv.addObject("eventos", eventos);
		return mv;

	}

}
package com.eventoapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventoapp.models.Evento;
import com.eventoapp.repository.EventoRepository;

@Service
public class EventoService {

	@Autowired
	private EventoRepository er;

	public Evento salvar(Evento evento) {
		return er.save(evento);
	}

	public List<Evento> procurarTodos() {
		return er.findAll();
	}
	
	public List<Evento> procurarName(String name){
		
		return er.findLikeName(name);
		
	}
	
	
}

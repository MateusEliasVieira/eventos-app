package com.seminfo.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seminfo.domain.model.EventoModel;
import com.seminfo.domain.repository.EventoRepository;
import com.seminfo.domain.service.EventoService;

@Service
public class EventoServiceImpl implements EventoService{
	
	// Classe com regras de negócios

	@Autowired
	private EventoRepository repository;
	
	@Override
	public List<EventoModel> listarEventos() {
		return repository.findAll();
	}

	@Override
	public EventoModel novoEvento(EventoModel eventoModel) {
		return repository.save(eventoModel);
	}

}

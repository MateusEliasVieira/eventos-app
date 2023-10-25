package com.seminfo.domain.service;

import java.util.List;

import com.seminfo.domain.model.EventoModel;

public interface EventoService {

	List<EventoModel> listarEventos();
	EventoModel novoEvento(EventoModel eventoModel);
	
}

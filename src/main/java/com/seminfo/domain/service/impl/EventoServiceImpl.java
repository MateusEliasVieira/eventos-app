package com.seminfo.domain.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seminfo.domain.model.EventoModel;
import com.seminfo.domain.model.InscritoModel;
import com.seminfo.domain.repository.EventoRepository;
import com.seminfo.domain.repository.InscritoRepository;
import com.seminfo.domain.service.EventoService;

@Service
public class EventoServiceImpl implements EventoService{
	
	// Classe com regras de negócios

	@Autowired
	private EventoRepository eventoRepository;
	@Autowired
	private InscritoRepository inscritoRepository;
	
	@Override
	public List<EventoModel> listarEventos() {
		return eventoRepository.findAll();
	}

	@Override
	public EventoModel novoEvento(EventoModel eventoModel) {
		return eventoRepository.save(eventoModel);
	}

	@Override
	public EventoModel incricao(Long idEvento, Long idInscrito) {
		Optional<EventoModel> evento = eventoRepository.findById(idEvento);
		if(evento.isPresent()) {
			Optional<InscritoModel> inscrito = inscritoRepository.findById(idInscrito);
			if(inscrito.isPresent()) {
				evento.get().getInscritos().add(inscrito.get());
				inscrito.get().getEventos().add(evento.get());
				return eventoRepository.save(evento.get());
			}else { return null; }
		}
		return null;
	}

}

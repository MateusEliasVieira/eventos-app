package com.seminfo.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.seminfo.api.model.EventoInput;
import com.seminfo.api.model.EventoOutput;
import com.seminfo.api.model.InscricaoInput;
import com.seminfo.api.model.InscritoOutput;
import com.seminfo.domain.model.EventoModel;
import com.seminfo.domain.service.EventoService;

@RestController
@RequestMapping(path = "/evento")
@CrossOrigin(origins = "http://localhost")
public class EventoController {
	
	@Autowired
	private EventoService service;
	
	
	private ModelMapper mapper = new ModelMapper();

//	@RequestMapping(path = "/teste", // Caminho da url
//			method = RequestMethod.GET, // Método aceito
//			consumes = MediaType.APPLICATION_JSON_VALUE, // Aceita solicitações com um tipo de conteúdo JSON (application/json).
//			produces = MediaType.APPLICATION_JSON_VALUE) // Produz uma resposta com um tipo de conteúdo JSON (application/json).
//	public String teste() {
//		return "{'text':'Olá programador!'}";
//	}
//	
	@GetMapping(path = "/listar-eventos")
	public ResponseEntity<List<EventoOutput>> listarEventos() {
		List<EventoModel> list = service.listarEventos();
		List<EventoOutput> list_output = new ArrayList<EventoOutput>();
		for(EventoModel evento: list) {
			list_output.add(mapper.map(evento, EventoOutput.class));
		}
		return new ResponseEntity<List<EventoOutput>>(list_output,HttpStatus.OK);
	}
	
	@PostMapping(path = "/novo-evento")
	public ResponseEntity<EventoOutput> novoEvento(@RequestBody EventoInput eventoInput) {
		EventoModel evento = service.novoEvento(mapper.map(eventoInput, EventoModel.class));
		EventoOutput eventoOutput = mapper.map(evento, EventoOutput.class);
		return new ResponseEntity<EventoOutput>(eventoOutput,HttpStatus.CREATED);
	}
	
	@PostMapping(path = "/inscrever-em-evento")
	public ResponseEntity<EventoOutput> inscricao(@RequestBody InscricaoInput inscricaoInput) {
		EventoModel evento = service.incricao(inscricaoInput.getIdEvento(), inscricaoInput.getIdInscrito());
		if(evento != null) {
			return new ResponseEntity<EventoOutput>(mapper.map(evento, EventoOutput.class),HttpStatus.OK);
		}
		return null;
	}
	
}

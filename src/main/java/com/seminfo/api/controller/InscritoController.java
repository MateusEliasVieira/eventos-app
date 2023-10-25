package com.seminfo.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seminfo.api.model.EventoInput;
import com.seminfo.api.model.EventoOutput;
import com.seminfo.api.model.InscritoInput;
import com.seminfo.api.model.InscritoOutput;
import com.seminfo.domain.model.EventoModel;
import com.seminfo.domain.model.InscritoModel;
import com.seminfo.domain.service.InscritoService;

@RestController
@RequestMapping(path = "/inscrito")
@CrossOrigin(origins = "http://localhost")
public class InscritoController {

	@Autowired
	private InscritoService service;

	private ModelMapper mapper = new ModelMapper();

	@GetMapping(path = "/listar-inscritos")
	public ResponseEntity<List<InscritoOutput>> listarEventos() {
		List<InscritoModel> list = service.listarInscritos();
		List<InscritoOutput> list_output = new ArrayList<InscritoOutput>();
		for (InscritoModel inscrito : list) {
			list_output.add(mapper.map(inscrito, InscritoOutput.class));
		}
		return new ResponseEntity<List<InscritoOutput>>(list_output, HttpStatus.OK);
	}

	@PostMapping(path = "/novo-inscrito")
	public ResponseEntity<InscritoOutput> novoInscrito(@RequestBody InscritoInput inscritoInput) {
		InscritoModel inscrito = service.addInscrito(mapper.map(inscritoInput, InscritoModel.class));
		InscritoOutput inscritoOutput = mapper.map(inscrito, InscritoOutput.class);
		return new ResponseEntity<InscritoOutput>(inscritoOutput, HttpStatus.CREATED);
	}

}

package com.seminfo.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seminfo.domain.model.InscritoModel;
import com.seminfo.domain.repository.InscritoRepository;
import com.seminfo.domain.service.InscritoService;

@Service
public class InscritoServiceImpl implements InscritoService{

	@Autowired
	private InscritoRepository repository;
	
	@Override
	public List<InscritoModel> listarInscritos() {
		return repository.findAll(); 
	}

	@Override
	public InscritoModel addInscrito(InscritoModel inscritoModel) {
		return repository.save(inscritoModel);
	}

}

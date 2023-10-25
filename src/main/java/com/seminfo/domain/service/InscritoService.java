package com.seminfo.domain.service;

import java.util.List;

import com.seminfo.domain.model.InscritoModel;

public interface InscritoService {
	
	List<InscritoModel> listarInscritos();
	InscritoModel addInscrito(InscritoModel inscritoModel);
	
}

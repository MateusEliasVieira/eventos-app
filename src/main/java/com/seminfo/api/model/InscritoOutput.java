package com.seminfo.api.model;

import java.util.ArrayList;
import java.util.List;
import com.seminfo.domain.model.EventoModel;

public class InscritoOutput {

	private Long idInscrito;
	private String nome;
	private String email;
	private List<EventoModel> eventos = new ArrayList<EventoModel>();

	public Long getIdInscrito() {
		return idInscrito;
	}

	public void setIdInscrito(Long idInscrito) {
		this.idInscrito = idInscrito;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<EventoModel> getEventos() {
		return eventos;
	}

	public void setEventos(List<EventoModel> eventos) {
		this.eventos = eventos;
	}

}

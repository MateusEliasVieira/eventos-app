package com.seminfo.api.model;

import java.util.ArrayList;
import java.util.List;

public class InscritoOutput {

	private Long idInscrito;
	private String nome;
	private String email;
	List<EventoOutput> eventos = new ArrayList<EventoOutput>();

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

	public List<EventoOutput> getEventos() {
		return eventos;
	}

	public void setEventos(List<EventoOutput> eventos) {
		this.eventos = eventos;
	}

}

package com.seminfo.domain.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class InscritoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idInscrito;
	private String nome;
	@Column(unique = true)
	private String email;

	@ManyToMany
	@JoinTable(name = "evento_inscrito", joinColumns = @JoinColumn(name = "inscrito_id"), inverseJoinColumns = @JoinColumn(name = "evento_id"))
	private List<EventoModel> eventos = new ArrayList<EventoModel>();
	
	public InscritoModel() {
		// TODO Auto-generated constructor stub
	}

	public InscritoModel(Long idInscrito, String nome, String email, List<EventoModel> eventos) {
		super();
		this.idInscrito = idInscrito;
		this.nome = nome;
		this.email = email;
		this.eventos = eventos;
	}

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

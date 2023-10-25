package com.seminfo.domain.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class EventoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEvento;
	@Column(nullable = false, length = 255)
	private String titulo;
	@Column(nullable = true, columnDefinition = "text")
	private String descricao;
	@Column(nullable = false)
	private Date dataEvento;
	@Column(nullable = false)
	private int vagas;

	@ManyToMany(mappedBy = "eventos")
	private List<InscritoModel> inscritos = new ArrayList<InscritoModel>();

	public EventoModel() {
		// TODO Auto-generated constructor stub
	}

	public EventoModel(Long idEvento, String titulo, String descricao, Date dataEvento, int vagas,
			List<InscritoModel> inscritos) {
		super();
		this.idEvento = idEvento;
		this.titulo = titulo;
		this.descricao = descricao;
		this.dataEvento = dataEvento;
		this.vagas = vagas;
		this.inscritos = inscritos;
	}

	public Long getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(Long idEvento) {
		this.idEvento = idEvento;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(Date dataEvento) {
		this.dataEvento = dataEvento;
	}

	public int getVagas() {
		return vagas;
	}

	public void setVagas(int vagas) {
		this.vagas = vagas;
	}

	public List<InscritoModel> getInscritos() {
		return inscritos;
	}

	public void setInscritos(List<InscritoModel> inscritos) {
		this.inscritos = inscritos;
	}

}

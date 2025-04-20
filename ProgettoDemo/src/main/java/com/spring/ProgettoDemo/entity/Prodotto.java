package com.spring.ProgettoDemo.entity;

import jakarta.persistence.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity // entità persistente
@Table(name = "Prodotti") // Nome del db
public class Prodotto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_Negozio")
	private Negozio negozio;
	public Prodotto() {
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Negozio getNegozio() {
		return negozio;
	}
	public void setNegozio(Negozio negozio) {
		this.negozio = negozio;
	}
	public Prodotto(Integer id, String nome, Negozio negozio) {
		super();
		this.id = id;
		this.nome = nome;
		this.negozio = negozio;
	}
	
}

package com.spring.ProgettoDemo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class DtoProdotto {
	private Integer id;

	@NotBlank(message = "Il nome del prodotto è obbligatorio")
	@Size(min = 1, max = 50, message = "Il nome del prodotto deve avere tra 1 e 50 caratteri")
	private String nome;

	private Integer negozioId;

	public DtoProdotto() {
		// Costruttore vuoto
	}

	public DtoProdotto(Integer id, String nome, Integer negozioId) {
		this.id = id;
		this.nome = nome;
		this.negozioId = negozioId;
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

	public Integer getNegozioId() {
		return negozioId;
	}

	public void setNegozioId(Integer negozioId) {
		this.negozioId = negozioId;
	}
}

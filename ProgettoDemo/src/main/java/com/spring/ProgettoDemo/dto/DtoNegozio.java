package com.spring.ProgettoDemo.dto;

import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class DtoNegozio {

	private Integer id;

	@NotBlank(message = "Il nome deve essere obbligatorio")
	@Size(min = 1, max = 30, message = "Il nome deve avere almeno 1 carattere e un massimo di 30")
	private String nome;

	@Email(message = "Email non valida")
	@NotBlank(message = "Email obbligatoria")
	private String email;

	private List<DtoProdotto> prodotti;

	public DtoNegozio() {
	}

	public DtoNegozio(Integer id, String nome, String email, List<DtoProdotto> prodotti) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.prodotti = prodotti;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<DtoProdotto> getProdotti() {
		return prodotti;
	}

	public void setProdotti(List<DtoProdotto> prodotti) {
		this.prodotti = prodotti;
	}
}

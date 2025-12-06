package com.sistema.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Responsavel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_responsavel;

	@Column(length = 30, nullable = false)
	private String nome;

	@Column(length = 30)
	private String cargo;

	public Responsavel() {
	}

	public Responsavel(String nome, String cargo) {
		this.nome = nome;
		this.cargo = cargo;
	}

	public Long getId_responsavel() {
		return id_responsavel;
	}

	public void setId_responsavel(Long id_responsavel) {
		this.id_responsavel = id_responsavel;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

}

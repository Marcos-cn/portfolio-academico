package com.sistema.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Projeto {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_projeto;
	private String nome;
	private String descricao;
	
	@OneToOne
	@JoinColumn(name = "responsavel_id")
	private Responsavel responsavel;
	
	
	@ManyToOne
	@JoinColumn(name = "tarefa_id")
	private Tarefa tarefa;
	
	
	public Responsavel getResponsavel() {
		return responsavel;
	}
	
	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}
	
	public Tarefa getTarefa() {
		return tarefa;
	}
	
	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}
	
	
	
	public Long getId_projeto() {
		return id_projeto;
	}
	public void setId_projeto(Long id_projeto) {
		this.id_projeto = id_projeto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}

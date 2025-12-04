package com.sistema.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Tarefa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_tarefa;
	private String titulo;
	private String descricao;
	private String prioridade;
	

	
	public Long getId_tarefa() {
		return id_tarefa;
	}
	public void setId_tarefa(Long id_tarefa) {
		this.id_tarefa = id_tarefa;
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
	public String getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}
	
	
	
}




package com.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.entity.Tarefa;

public interface TarefaRepository 
		
	extends JpaRepository <Tarefa, Long> {
	
}



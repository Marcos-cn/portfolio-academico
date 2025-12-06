package com.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.entity.Projeto;

public interface ProjetoRepository 

extends JpaRepository <Projeto, Long>{

}

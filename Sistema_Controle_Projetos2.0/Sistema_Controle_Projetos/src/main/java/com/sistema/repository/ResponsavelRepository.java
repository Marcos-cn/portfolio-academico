package com.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.entity.Responsavel;

public interface ResponsavelRepository 
	
	extends JpaRepository <Responsavel, Long> {
	
}

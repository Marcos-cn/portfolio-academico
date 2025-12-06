package com.sistema.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.entity.Projeto;
import com.sistema.repository.ProjetoRepository;


@RestController
@RequestMapping("/api/projetos")
public class ProjetoController {
	
	@Autowired
	ProjetoRepository projetoRepository;
	
	@GetMapping
	public List<Projeto> listarProjetos(){
		return projetoRepository.findAll();
		
	}
	
	@PostMapping
	public Projeto salvarProjeto(@RequestBody Projeto projeto) {
		return projetoRepository.save(projeto);
	}
	
	@DeleteMapping("/{id}")
	   public void deletarProjeto(@PathVariable Long id) {
	       projetoRepository.deleteById(id);
	   }

	@PutMapping("/{id}")
	   public Projeto atualizarProjeto(@PathVariable Long id, @RequestBody Projeto novaProjeto) {
	       Optional<Projeto> optionalProjeto = projetoRepository.findById(id);
	       if (optionalProjeto.isPresent()) {
	    	   Projeto projeto = optionalProjeto.get();
	           projeto.setNome(null);
	           projeto.setResponsavel(null);
	           projeto.setId_projeto(id);
	           return projetoRepository.save(projeto);
	       }
	       return null;

}

}

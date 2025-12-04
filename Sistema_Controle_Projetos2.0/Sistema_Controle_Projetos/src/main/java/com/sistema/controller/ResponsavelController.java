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

import com.sistema.entity.Responsavel;
import com.sistema.repository.ResponsavelRepository;



@RestController
@RequestMapping("/api/responsaveis")
public class ResponsavelController {
	
	@Autowired
	ResponsavelRepository responsavelRepository;
	
	@GetMapping
	public List<Responsavel> listarResponsaveis(){
		return responsavelRepository.findAll();
		
	}
	
	@PostMapping
	public Responsavel salvarResponsavel(@RequestBody Responsavel responsavel) {
		return responsavelRepository.save(responsavel);
	}

	@DeleteMapping("/{id}")
	   public void deletarResponsavel(@PathVariable Long id) {
	       responsavelRepository.deleteById(id);
	   }

	@PutMapping("/{id}")
	   public Responsavel atualizarResponsavel(@PathVariable Long id, @RequestBody Responsavel novaResponsavel) {
	       Optional<Responsavel> optionalResponsavel = responsavelRepository.findById(id);
	       if (optionalResponsavel.isPresent()) {
	    	   Responsavel responsavel = optionalResponsavel.get();
	           responsavel.setCargo(null);
	           responsavel.setNome(null);
	           responsavel.setId_responsavel(id);
	           return responsavelRepository.save(responsavel);
	       }
	       return null;

}

}


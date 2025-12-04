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

import com.sistema.entity.Tarefa;
import com.sistema.repository.TarefaRepository;



@RestController
@RequestMapping("/api/tarefas")
public class TarefaController{
		
	@Autowired
	TarefaRepository tarefaRepository;
	
	@GetMapping
	public List<Tarefa> listarTarefas(){
		return tarefaRepository.findAll();
		
	}
	
	@PostMapping
	public Tarefa salvarTarefa(@RequestBody Tarefa tarefa) {
		return tarefaRepository.save(tarefa);
	}

	@DeleteMapping("/{id}")
	   public void deletarTarefa(@PathVariable Long id) {
	       tarefaRepository.deleteById(id);
	   }

	@PutMapping("/{id}")
	   public Tarefa atualizarTarefa(@PathVariable Long id, @RequestBody Tarefa novaTarefa) {
	       Optional<Tarefa> optionalTarefa = tarefaRepository.findById(id);
	       if (optionalTarefa.isPresent()) {
	           Tarefa tarefa = optionalTarefa.get();
	           tarefa.setDescricao(null);
	           tarefa.setPrioridade(null);
	           tarefa.setTitulo(null);
	           return tarefaRepository.save(tarefa);
	       }
	       return null;
	   }
 
}
	


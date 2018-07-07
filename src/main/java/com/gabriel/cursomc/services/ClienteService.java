package com.gabriel.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabriel.cursomc.domain.Cliente;
import com.gabriel.cursomc.repositories.ClienteRepository;
import com.gabriel.cursomc.services.exceptions.ObjectNotFoundExcepiton;

@Service
public class ClienteService {
	//responsavel por fazer consult no repository
	
	
	//qndo declara uma dependencia dentro de uma classe	e coloca o autowired, 
	//essa dependencia sera instanciada automaticamente pelo spring	
	@Autowired
	private ClienteRepository repo;

		public Cliente find(Integer id) {
			Optional<Cliente> obj = repo.findById(id);
			
			return obj.orElseThrow(() -> new ObjectNotFoundExcepiton(
			"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
		}
}

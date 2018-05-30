package com.gabriel.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabriel.cursomc.domain.Pedido;
import com.gabriel.cursomc.repositories.PedidoRepository;
import com.gabriel.cursomc.services.exceptions.ObjectNotFoundExcepiton;

@Service
public class PedidoService {
	//responsavel por fazer consult no repository
	
	
	//qndo declara uma dependencia dentro de uma classe	e coloca o autowired, 
	//essa dependencia sera instanciada automaticamente pelo spring	
	@Autowired
	private PedidoRepository repo;

		public Pedido buscar(Integer id) {
			Optional<Pedido> obj = repo.findById(id);
			
			return obj.orElseThrow(() -> new ObjectNotFoundExcepiton(
			"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
		}
}

package com.gabriel.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.gabriel.cursomc.domain.Categoria;
import com.gabriel.cursomc.repositories.CategoriaRepository;
import com.gabriel.cursomc.services.exceptions.DataIntegrityException;
import com.gabriel.cursomc.services.exceptions.ObjectNotFoundExcepiton;

@Service
public class CategoriaService {
	//responsavel por fazer consult no repository
	
	
	//qndo declara uma dependencia dentro de uma classe	e coloca o autowired, 
	//essa dependencia sera instanciada automaticamente pelo spring	
	@Autowired
	private CategoriaRepository repo;

		public Categoria find(Integer id) {
			Optional<Categoria> obj = repo.findById(id);
			
			return obj.orElseThrow(() -> new ObjectNotFoundExcepiton(
			"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
		}
		
		public Categoria insert(Categoria obj) {
			obj.setId(null);
			return repo.save(obj);
		}
		
		public Categoria update(Categoria obj) {
			find(obj.getId());
			return repo.save(obj);
		}
		
		public void delete(Integer id) {
			find(id);
			try {
				repo.deleteById(id);
			}
			catch (DataIntegrityViolationException e) {
				throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos");
			}
			
		}
		
		public List<Categoria> findAll(){
			return repo.findAll();
		}
}

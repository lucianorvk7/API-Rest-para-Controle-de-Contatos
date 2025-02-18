package br.com.lc.AppControleContatos.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lc.AppControleContatos.model.Contatos;
import br.com.lc.AppControleContatos.service.ContatosService;
import io.swagger.v3.oas.annotations.Operation;

/**
 * Controlador REST para gerenciar contatos.
 * Define endpoints para CRUD de contatos no sistema.
 */
@RestController
@RequestMapping("/api/contatos") // http://localhost:8080/api/contatos
public class ContatosResource {
	
	@Autowired
	private ContatosService contatosService;
	
	@PostMapping // http://localhost:8080/api/contatos
	@Operation(summary = "Este Endpoint é para salvar um contato e depende de uma pessoa")
	public ResponseEntity<Contatos> save(@RequestBody Contatos contatos){
		Contatos newContatos = contatosService.save(contatos);
		if(newContatos == null)
			return ResponseEntity.badRequest().build();//400
		return ResponseEntity.ok(newContatos);//200
		
	}
	
	@GetMapping("/{id}")
	@Operation(summary = "Este Endpoint é para buscar um contato por id e depende de uma id de pessoa")
	public ResponseEntity<Optional<Contatos>> findById(@PathVariable Long id){
		Optional<Contatos> findContatos = contatosService.findById(id);
		if(findContatos == null)
			return ResponseEntity.badRequest().build();//400
		return ResponseEntity.ok(findContatos);//200
	}
	
	@GetMapping
	@Operation(summary = "Este Endpoint é para listar todos os contato")
	public ResponseEntity<List<Contatos>> findAll(){
		List<Contatos> findContatos = contatosService.findAll();
		if(findContatos == null)
			return ResponseEntity.badRequest().build();//400
		return ResponseEntity.ok(findContatos);//200
	}
	
	@PutMapping
	@Operation(summary = "Este Endpoint é para atualizar um contato e depende de uma pessoa")
	public ResponseEntity<Contatos> update(@RequestBody Contatos contatos){
		
		Contatos updContatos = contatosService.update(contatos);
		if(updContatos == null)
			return ResponseEntity.badRequest().build();//400
		return ResponseEntity.ok(updContatos);//200
	}
	
	@DeleteMapping("/{id}")
	@Operation(summary = "Este Endpoint é para deletar um contato e depende de uma id de uma pessoa")
	public ResponseEntity<?> delete(@PathVariable Long id){
		contatosService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);//204
	}
	

}

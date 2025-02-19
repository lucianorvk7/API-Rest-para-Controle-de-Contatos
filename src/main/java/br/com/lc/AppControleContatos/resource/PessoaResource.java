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

import br.com.lc.AppControleContatos.dto.MalaDiretaRecord;
import br.com.lc.AppControleContatos.model.Pessoa;

import br.com.lc.AppControleContatos.service.PessoaService;
import io.swagger.v3.oas.annotations.Operation;

/**
 * Controlador REST para gerenciar operações de CRUD da entidade Pessoa.
 */

@RestController// Informando para o spring que isso é um cpntrolador
@RequestMapping("/api/pessoa") // http://localhost:8080/api/pessoa  // Define a URL base da API
public class PessoaResource {
	
	@Autowired
	PessoaService pessoaService;
	
	@PostMapping //POST http://localhost:8080/api/pessoa
	@Operation(summary = "Este Endpoint é para criar uma nova pessoa no sistema")
	public ResponseEntity<Pessoa> save(@RequestBody Pessoa pessoa) {
		Pessoa newPessoa = pessoaService.save(pessoa);
		if(newPessoa == null) {
			return ResponseEntity.badRequest().build();// dê status code 404
		}else {
			return ResponseEntity.ok(newPessoa);// dê status code 200 e retorna o objeto
		}
	}
	
	@GetMapping("/{id}") //GET http://localhost:8080/api/pessoa/{id}
	@Operation(summary = "Este Endpoint é para buscar uma pessoa no sistema pelo ID")
	public ResponseEntity<Optional<Pessoa>> findById(@PathVariable Long id){
		Optional<Pessoa> pessoa = pessoaService.findById(id);
		if(pessoa.isEmpty()) { // isEmpty quer dizer que está vazio no Optional 
			return ResponseEntity.notFound().build();//404
		}else {
			return ResponseEntity.ok(pessoa);//200
		}
	}
	
	@GetMapping //GET http://localhost:8080/api/pessoa
	@Operation(summary = "Este Endpoint é para retornar uma lista com todas as pessoas cadastradas no sistema")
	public ResponseEntity<List<Pessoa>> findAll(){
		List<Pessoa> pessoa = pessoaService.findAll();
		if(pessoa == null) 
			return ResponseEntity.badRequest().build();
		if(pessoa.size() == 0) 
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(pessoa);
		
	}
	
	@GetMapping("/maladireta/{id}")
	@Operation(summary = "Exibe uma pessoa com informações para mala direta")
	public ResponseEntity<MalaDiretaRecord> getMalaDiretaPorId(@PathVariable Long id) {
	    Optional<Pessoa> pessoa = pessoaService.findById(id);

	    if (pessoa.isEmpty()) {
	        return ResponseEntity.notFound().build();
	    }

	    return ResponseEntity.ok(new MalaDiretaRecord(pessoa.get()));
	}

	@PutMapping //PUT http://localhost:8080/api/pessoa
	@Operation(summary = "Este Endpoint é para atualizar os dados de uma pessoa existente no sistema")
	public ResponseEntity<Pessoa> update(@RequestBody Pessoa pessoa){
		Pessoa updPessoa = pessoaService.update(pessoa);
		if(updPessoa == null) {
			return ResponseEntity.badRequest().build();// dê status code 404
		}else {
			return ResponseEntity.ok(updPessoa);// dê status code 200 e retorna o objeto
		}
		
	}
	
	@DeleteMapping ("/{id}") //DELETE http://localhost:8080/api/pessoa/{id}
	@Operation(summary = "Este Endpoint é para excluir uma pessoa pelo ID no sistema")
	public ResponseEntity<?> delete(@PathVariable Long id){
		pessoaService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);//204
		
	}
	

}

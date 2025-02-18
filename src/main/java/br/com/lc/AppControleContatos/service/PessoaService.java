package br.com.lc.AppControleContatos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lc.AppControleContatos.model.Pessoa;
import br.com.lc.AppControleContatos.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	//CRUD - CREATE
	public Pessoa save(Pessoa pessoa) {
		//Regra de negocio:
		//Se o campo nome está preenchido
		if(pessoa.getNome() == null) {
			System.out.println("Nome da pessoa vazio");
			return null;
		}
		//Se o campo enderecp está preenchido
		if(pessoa.getEndereco() == null) {
			System.out.println("Endereco da pessoa vazio");
			return null;
		}
		//Se o campo cep está preenchido
		if(pessoa.getCep() == null) {
			System.out.println("Cep da pessoa vazio");
			return null;
		}
		//Se o campo cidade está preenchido
		if(pessoa.getCidade() == null) {
			System.out.println("Cidade da pessoa vazio");
			return null;
		}
		//Se o campo UF está preenchido
		if(pessoa.getUf() == null) {
			System.out.println("UF da pessoa vazio");
			return null;
		}
		try {
			//Vai no banco de dados 
			//' INSERT INTO pessoa( nome, endereco, cep,, cidade, uf) 
			//VALUES( pessoa.getNome, pessoa.getEndereco, 
			//pessoa.getCep, pessoa.getCidade, pessoa.getUf);
			return pessoaRepository.save(pessoa);
		}catch (Exception e) {
			System.out.println("Erro ao inserir pessoa" + pessoa.toString() + ": " + e.getMessage());
			return null;
			
		}
		
		
		
	}
	
	//CRUD - READ (leitura individual ou lista)
	public Optional<Pessoa> findById(Long id){
		//select * from pessoa where id = ?id
		return pessoaRepository.findById(id);
		
	}
	
	public List<Pessoa> findAll(){
		//select * from pessoa 
		return pessoaRepository.findAll();
	}
	
	//CRUD - UPDATE
	public Pessoa update(Pessoa pessoa) {
		//Regra de Negocio:
		// Verificar se a pessoa existe; Se existir, atualiza; Caso não, insere novo.
		// --------------------------------------------------------
		// Pesquisar Pessoa
		
		Optional<Pessoa> findPessoa = pessoaRepository.findById(pessoa.getId());
		
		// Se a pessoa existir, atualizar:
		if(findPessoa.isPresent()) {
			//(pessoa.getId, pessoa.getNome, pessoa.getEndereco,
			//pessoa.getCep, pessoa.getCidade, pessoa.getUf);
			Pessoa updPessoa = findPessoa.get(); //setId
			updPessoa.setNome(pessoa.getNome());
			updPessoa.setEndereco(pessoa.getEndereco());
			updPessoa.setCep(pessoa.getCep());
			updPessoa.setCidade(pessoa.getCidade());
			updPessoa.setUf(pessoa.getUf());
			return pessoaRepository.save(updPessoa);//UPDATE
		}
		return pessoaRepository.save(pessoa);//INSERT
		
	}
	
	//CRUD - DELETE  
	public void delete(long id) {
		//delete * from pessoa where id = ?id
		pessoaRepository.deleteById(id);
	}
	
}

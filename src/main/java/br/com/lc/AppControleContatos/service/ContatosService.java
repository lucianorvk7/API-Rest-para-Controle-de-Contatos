package br.com.lc.AppControleContatos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lc.AppControleContatos.model.Contatos;
import br.com.lc.AppControleContatos.model.Pessoa;
import br.com.lc.AppControleContatos.repository.ContatosRepository;
import br.com.lc.AppControleContatos.repository.PessoaRepository;

@Service
public class ContatosService {
	
	@Autowired
	private ContatosRepository contatosRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Contatos save(Contatos contatos) {
		//Verificar se o produto existe, caso não avisar:
		if(contatos.getPessoa().getId() != null) {
			//buscar a pessoa mo BD:
			Optional<Pessoa> findPessoa = pessoaRepository
					.findById(contatos.getPessoa().getId());
			if(findPessoa.isEmpty()) {
				System.out.println("Pessoa não encontrada");
				return null;
			}else {
				contatos.setPessoa(findPessoa.get());
				return contatosRepository.save(contatos);
			}
		}else {
			System.out.println("Pessoa nula");
			return null;
		}
	}
	
	public Optional<Contatos> findById(Long id) {
		return contatosRepository.findById(id);
	}
	
	public List<Contatos> findAll(){
		return contatosRepository.findAll();
	}
	
	public Contatos update(Contatos contatos) {
		//pesquisar se os contatos existe
		Optional<Contatos> findContatos = contatosRepository
				.findById(contatos.getId());
		//se existir, atualizar:
		if(findContatos.isPresent()) {
			//variavel auxiliar 
			Contatos updContatos = findContatos.get();
			updContatos.setTipo(contatos.getTipo());
			updContatos.setContato(contatos.getContato());
			//gravar no banco
			return contatosRepository.save(updContatos);
		}
		return contatosRepository.save(contatos);
	}
	
	public void delete(Long id) {
		
		contatosRepository.deleteById(id);
		
	}

}

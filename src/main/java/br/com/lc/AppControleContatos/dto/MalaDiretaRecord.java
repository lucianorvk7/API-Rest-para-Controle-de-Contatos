package br.com.lc.AppControleContatos.dto;

import br.com.lc.AppControleContatos.model.Pessoa;

public record MalaDiretaRecord(Long id, String nome, String endereco, String cep, String cidade, String uf) {
	
		public MalaDiretaRecord(Pessoa pessoa) {
		this(pessoa.getId(),pessoa.getNome(), pessoa.getEndereco(),pessoa.getCep(), pessoa.getCidade(), pessoa.getUf());
	}

}



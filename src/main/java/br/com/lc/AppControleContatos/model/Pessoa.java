package br.com.lc.AppControleContatos.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name ="tb_pessoa")
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //AUTOINCREMENTO DO ID
	private Long id;
	
	@Column(nullable = false)// not null
	private String nome;
	
	@Column(nullable = true)// not null
	private String endereco;
	
	@Column(nullable = true)// not null
	private Double cep;
	
	@Column(nullable = true)// not null
	private String cidade;
	
	@Column(nullable = true)// not null
	private String uf;
	
	@OneToMany(mappedBy = "pessoa")
	@JsonIgnore
	private List<Contatos> contatos;
	
	public Pessoa () {}
	public Pessoa(Long id, String nome, String endereco, Double cep, String cidade, String uf) {
		
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.cep = cep;
		this.cidade = cidade;
		this.uf = uf;
	}

	

	public List<Contatos> getContatos() {
		return contatos;
	}
	public void setContatos(List<Contatos> contatos) {
		this.contatos = contatos;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	
	public Double getCep() {
		return cep;
	}

	public void setCep(Double cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}
	
	@Override
	public String toString() {
		String retorno = "[" + 
					"ID:" 		+ this.id 		+ ", " +
					"Nome:" 	+ this.nome 	+ ", " +
					"Endereço:" + this.endereco + ", " +
					"CEP:" 		+ this.cep 		+ ", " +
					"Cidade:" 	+ this.cidade 	+ ", " + 
					"UF:" 		+ this.uf 		+ "]";
		
		return retorno;
	}

	
	

}

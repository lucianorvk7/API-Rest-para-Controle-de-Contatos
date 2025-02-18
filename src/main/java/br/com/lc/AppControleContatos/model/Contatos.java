package br.com.lc.AppControleContatos.model;

 
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_contatos")
public class Contatos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Autoincrement
	public Long id;
	
	@Column(nullable = false)
	private Integer tipo;
	
	
	@Column(nullable = false)
	private Integer contato;
	
	@ManyToOne()
	@JoinColumn(name = "pessoa_id", referencedColumnName = "id", nullable = false)
	private Pessoa pessoa;
	
	public Contatos() {
		
	}

	
	public Contatos(Long id, Integer tipo, Integer contato, Pessoa pessoa) {
		
		this.id = id;
		this.tipo = tipo;
		this.contato = contato;
		this.pessoa = pessoa;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Integer getTipo() {
		return tipo;
	}


	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}


	public Integer getContato() {
		return contato;
	}


	public void setContato(Integer contato) {
		this.contato = contato;
	}


	public Pessoa getPessoa() {
		return pessoa;
	}


	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	
	@Override
	public String toString() {
		return "Contatos: [ "    + 
					"id:" 		+ this.id 				+ "\n" +
					"tipo:" 	+ this.tipo 			+ "\n" +
					"contato"   + this.contato    		+ "\n" +
					"pessoa:" 	+ (this.pessoa != null ? pessoa.getId() : "null")	+ "]";
		
		
	}
	
	

}

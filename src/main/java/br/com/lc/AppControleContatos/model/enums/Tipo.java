package br.com.lc.AppControleContatos.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;


@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Tipo {
	
	Residencial("1", "Telefone Residencial"),
	Celular("2", "Telefone celular"),
	Trabalho("3", "Telefone do trabalho"),
	Email("4", "E-mail");
 	
	private String codigo;
	private String descricao;
	
	private Tipo(String codigo, String descricao) {
		 this.codigo = codigo;
		 this.descricao = descricao;
		 
		 
		 
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@JsonCreator
	public static Tipo Value(String codigo) {
		if(codigo.equals("1")) {
			return Residencial;
		}else if(codigo.equals("2")){
			return Celular;
		}else if(codigo.equals("3")) {
			return Trabalho;
		}else if(codigo.equals("4")) {
			return Email;
		}else {
			return null;
		}
			
	}
}



package com.pedroquintanilha.testeattornatus.dto;

import java.io.Serializable;

import com.pedroquintanilha.testeattornatus.entities.Endereco;
import com.pedroquintanilha.testeattornatus.entities.Pessoa;

public class EnderecoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String logradouro;
	private Long cep;
	private Integer numero;
	private String cidade;
	
	private Pessoa pessoa;
	
	public EnderecoDTO() {
	}

	public EnderecoDTO(Long id, String logradouro, Long cep, Integer numero, String cidade, Pessoa pessoa) {
		super();
		this.id = id;
		this.logradouro = logradouro;
		this.cep = cep;
		this.numero = numero;
		this.cidade = cidade;
		this.setPessoa(pessoa);
	}
	
	public EnderecoDTO(Endereco obj) {
		id = obj.getId();
		logradouro = obj.getLogradouro();
		cep = obj.getCep();
		numero = obj.getNumero();
		cidade = obj.getCidade();
		setPessoa(obj.getPessoa());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Long getCep() {
		return cep;
	}

	public void setCep(Long cep) {
		this.cep = cep;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}

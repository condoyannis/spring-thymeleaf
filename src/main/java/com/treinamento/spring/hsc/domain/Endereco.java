package com.treinamento.spring.hsc.domain;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@SuppressWarnings("serial")
@Entity
@Table(name = "ENDERECOS")

public class Endereco extends AbstractyEntity<Long> {

	@NotBlank
	@Column(nullable = false, length = 255)
	private String logradouro;

	@NotBlank
	@Column(nullable = false)
	private String bairro;
	
	@NotBlank
	@Column(nullable = false)
	private String cidade;
	
//	@PastOrPresent(message = "{NotNull.endereco.uf}")
	@Column(nullable = false, length = 2)
	@Enumerated(EnumType.STRING)
	private UF uf; 
	
	@Column(nullable = false, length =  5)
	private Integer numero;
	
	@Column(nullable = true)
	private String complemento;
	
	@Column(nullable = false, length = 9)
	private Integer cep;

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}



	public UF getUf() {
		return uf;
	}

	public void setUf(UF uf) {
		this.uf = uf;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Integer getCep() {
		return cep;
	}

	public void setCep(Integer cep) {
		this.cep = cep;
	}
	
	
}
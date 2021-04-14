package com.treinamento.spring.hsc.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity
@Table(name = "DEPARTAMENTOS")
@Getter @Setter

public class Departamento extends AbstractyEntity<Long> {

	@NotBlank(message = "Nome obrigatório.")
	@Size(min = 3, max = 60, message = "Min {min} e Max {max} .")
	@Column(name = "nome", nullable = false, unique = true, length = 60)
	private String nome;
	
	@OneToMany(mappedBy = "departamento")
	private List<Cargo> cargos;
}
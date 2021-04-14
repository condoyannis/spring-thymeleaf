package com.treinamento.spring.hsc.domain;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity
@Table(name = "CARGOS")
@Getter @Setter
public class Cargo extends AbstractyEntity<Long> {

	@NotBlank(message = "Nome obrigatório.")
	@Size(min = 3, max = 60, message = "Min {min} e Max {max} .")
	@Column(name = "nome", nullable = false, unique = true, length = 60)
	private String nome;

	@NotNull(message = "Selecione um departamento.")
	@ManyToOne
	@JoinColumn(name = "id_departamento_fk")
	private Departamento departamento;

	@OneToMany(mappedBy = "cargo")
	private List<Funcionario> funcionarios;
}
package com.treinamento.spring.hsc.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity
@Table(name = "FUNCIONARIOS")
public class Funcionario extends AbstractyEntity<Long> {

	@NotBlank
	@Column(name = "nome", nullable = false, unique = true, length = 60)
	@Getter @Setter
	private String nome;
	
	@NotNull
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	@Column(nullable = false, columnDefinition = "DECIMAL (7,2) DEFAULT 0.00")
	@Getter @Setter
	private BigDecimal salario;

	@NotNull
	@PastOrPresent(message = "{PastOrPresent.funcionario.dataEntrada}")
	@DateTimeFormat(iso = ISO.DATE)
	@Column(nullable = false, columnDefinition = "DATE")
	@Getter @Setter
	private LocalDate dataEntrada;

	@DateTimeFormat(iso = ISO.DATE)
	@Column(columnDefinition = "DATE")
	@Getter @Setter
	private LocalDate dataSaida;
	
	@Valid
	@OneToOne (cascade = CascadeType.ALL)
	@JoinColumn(name="endereco_id_fk")
	private Endereco endereco;
	
	@ManyToOne
	@JoinColumn(name="cargo_id_fk")
	@Getter @Setter
	private Cargo cargo;

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}

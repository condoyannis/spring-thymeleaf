package com.treinamento.spring.hsc.util;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class PaginacaoUtil<T> {
	private int tamanho, pagina;
	private long totalPaginas;
	private List<T> registros;
	private String ordenacao;
}
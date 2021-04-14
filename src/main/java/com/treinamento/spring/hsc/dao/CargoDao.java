package com.treinamento.spring.hsc.dao;

import java.util.List;

import com.treinamento.spring.hsc.domain.Cargo;
import com.treinamento.spring.hsc.util.PaginacaoUtil;

public interface CargoDao {
	void save(Cargo entity);
	void update(Cargo entity);
	void delete(Long id);
	Cargo findById(Long id);
	public List<Cargo> findAll();
	public PaginacaoUtil<Cargo> buscaPaginada(int numeroPagina,String ordenacao);
}
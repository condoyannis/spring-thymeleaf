package com.treinamento.spring.hsc.dao;

import java.time.LocalDate;
import java.util.List;

import com.treinamento.spring.hsc.domain.Funcionario;

public interface FuncionarioDao {
	void save(Funcionario entity);
	void update(Funcionario entity);
	void delete(Long id);
	Funcionario findById(Long id);
	public List<Funcionario> findAll();
	List<Funcionario> findByName(String name);
	List<Funcionario> findByCargo(Long cargo);
	List<Funcionario> findByData(LocalDate entrada, LocalDate saida);
	List<Funcionario> findByDataEntrada(LocalDate entrada);
	List<Funcionario> findByDataSaida(LocalDate saida);
}

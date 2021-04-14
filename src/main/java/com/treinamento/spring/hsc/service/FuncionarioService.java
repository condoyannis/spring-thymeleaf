package com.treinamento.spring.hsc.service;

import java.time.LocalDate;
import java.util.List;

import com.treinamento.spring.hsc.domain.Funcionario;

public interface FuncionarioService {
	void save(Funcionario funcionario);
	void update(Funcionario funcionario);
	void delete(Long id);
	Funcionario findById(Long id);
	public List<Funcionario> findAll();
	public List<Funcionario> findByName(String name);
	public List<Funcionario> findByCargo(Long cargo);
	public List<Funcionario> findByData(LocalDate entrada, LocalDate saida);
}

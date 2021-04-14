package com.treinamento.spring.hsc.dao;

import java.util.List;

import com.treinamento.spring.hsc.domain.Departamento;

public interface DepartamentoDao {
	void save(Departamento entity);
	void update(Departamento entity);
	void delete(Long id);
	Departamento findById(Long id);
	public List<Departamento> findAll();
}

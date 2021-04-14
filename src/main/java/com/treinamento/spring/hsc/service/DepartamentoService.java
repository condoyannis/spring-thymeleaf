package com.treinamento.spring.hsc.service;

import java.util.List;

import com.treinamento.spring.hsc.domain.Departamento;

public interface DepartamentoService {
	void save(Departamento departamento);
	void update(Departamento departamento);
	void delete(Long id);
	Departamento findById(Long id);
	public List<Departamento> findAll();
	boolean departamentoHasCargos(Long id);
}

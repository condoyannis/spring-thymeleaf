package com.treinamento.spring.hsc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.treinamento.spring.hsc.dao.DepartamentoDao;
import com.treinamento.spring.hsc.domain.Departamento;

@Service
public class DepartamentoServiceImpl implements DepartamentoService{

	@Autowired
	private DepartamentoDao dao;
	
	@Override
	@Transactional(readOnly = false)
	public void save(Departamento Departamento) {
		dao.save(Departamento);
	}

	@Override
	@Transactional(readOnly = false)
	public void update(Departamento Departamento) {
		dao.update(Departamento);
	}

	@Override @Transactional(readOnly = false)
	public void delete(Long id) {
		dao.delete(id);
	}

	@Override  @Transactional(readOnly = true)
	public Departamento findById(Long id) {
		return dao.findById(id);
	}

	@Override  @Transactional(readOnly = true)
	public List<Departamento> findAll() {
		return dao.findAll();
	}

	@Override
	public boolean departamentoHasCargos(Long id) {
		return !findById(id).getCargos().isEmpty();
	}

}

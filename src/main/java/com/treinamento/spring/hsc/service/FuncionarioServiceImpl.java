package com.treinamento.spring.hsc.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.treinamento.spring.hsc.dao.FuncionarioDao;
import com.treinamento.spring.hsc.domain.Funcionario;

@Service @Transactional(readOnly = true)
public class FuncionarioServiceImpl implements FuncionarioService{

	@Autowired
	private FuncionarioDao dao;
	
	@Override
	@Transactional(readOnly = false)
	public void save(Funcionario Funcionario) {
		dao.save(Funcionario);
	}

	@Override
	@Transactional(readOnly = false) 
	public void update(Funcionario Funcionario) {
		dao.update(Funcionario);
	}

	@Override @Transactional(readOnly = false)
	public void delete(Long id) {
		dao.delete(id);
	}

	@Override  @Transactional(readOnly = true)
	public Funcionario findById(Long id) {
		return dao.findById(id);
	}

	@Override  @Transactional(readOnly = true)
	public List<Funcionario> findAll() {
		return dao.findAll();
	}

	@Override
	public List<Funcionario> findByName(String name) {
		return dao.findByName(name);
	}

	@Override
	public List<Funcionario> findByCargo(Long cargo) {
		return dao.findByCargo(cargo);
	}

	@Override
	public List<Funcionario> findByData(LocalDate entrada, LocalDate saida) {
		if(entrada!=null && saida !=null) {
			return dao.findByData(entrada, saida);	
		}else if(entrada !=null ){
			return dao.findByDataEntrada(entrada);
		}else if(saida !=null ) {
			return dao.findByDataSaida(saida);
		}
		else 
			return new ArrayList<>();
	}
}

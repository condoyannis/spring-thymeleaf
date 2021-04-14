package com.treinamento.spring.hsc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.treinamento.spring.hsc.dao.CargoDao;
import com.treinamento.spring.hsc.domain.Cargo;
import com.treinamento.spring.hsc.util.PaginacaoUtil;

@Service @Transactional(readOnly = false)
public class CargoServiceImpl implements CargoService{

	@Autowired
	private CargoDao dao;
	
	@Override
	public void save(Cargo cargo) {
		dao.save(cargo);
	}

	@Override
	public void update(Cargo cargo) {
		dao.update(cargo);
	}

	@Override
	public void delete(Long id) {
		dao.delete(id);
	}

	@Override  @Transactional(readOnly = true)
	public Cargo findById(Long id) {
		return dao.findById(id);
	}

	@Override  @Transactional(readOnly = true)
	public List<Cargo> findAll() {
		return dao.findAll();
	}

	@Override
	public boolean cargoHasCargos(Long id) {
		return !findById(id).getFuncionarios().isEmpty();
	}

	@Override
	public PaginacaoUtil<Cargo> buscaPaginada(int numeroPagina,String ordenacao) {
		return dao.buscaPaginada(numeroPagina,ordenacao);
	}

}

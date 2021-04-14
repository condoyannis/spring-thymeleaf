package com.treinamento.spring.hsc.service;

import java.util.List;

import com.treinamento.spring.hsc.domain.Cargo;
import com.treinamento.spring.hsc.util.PaginacaoUtil;

public interface CargoService {
	void save(Cargo cargo);
	void update(Cargo cargo);
	void delete(Long id);
	Cargo findById(Long id);
	public List<Cargo> findAll();
	public boolean cargoHasCargos(Long id); 
	public PaginacaoUtil<Cargo> buscaPaginada(int numeroPagina,String ordenacao);
}

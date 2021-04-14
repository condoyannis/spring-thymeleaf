package com.treinamento.spring.hsc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.treinamento.spring.hsc.domain.Cargo;
import com.treinamento.spring.hsc.util.PaginacaoUtil;

@Repository
public class CargoDaoImpl extends AbstractDao<Cargo, Long>  implements CargoDao{
	public PaginacaoUtil<Cargo> buscaPaginada(int numeroPagina,String ordenacao){
		int maxResults = 2;
		int inicio = (numeroPagina - 1) * maxResults;
		
		List<Cargo> cargos = getEntityManager().createQuery("select c from Cargo c order by c.nome "+ordenacao, Cargo.class).
				setFirstResult(inicio).
				setMaxResults(maxResults).
				getResultList();
		
		long countRegistros = count();
		long totalPaginas = (countRegistros + (maxResults - 1)) / maxResults;
		
		return new PaginacaoUtil<>(maxResults, numeroPagina, totalPaginas, cargos,ordenacao);
	
	}
	
	public long count() {
		return getEntityManager().
				createQuery("select count(*) from Cargo", Long.class).
				getSingleResult();
		
	}
}

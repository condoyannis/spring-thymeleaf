package com.treinamento.spring.hsc.web.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.treinamento.spring.hsc.domain.Departamento;
import com.treinamento.spring.hsc.service.DepartamentoService;

@Component
public class StringToDepartamentoConverter implements Converter<String, Departamento> {
	
	@Autowired
	DepartamentoService departamentoService;
	@Override
	public Departamento convert(String text) {
		if(text.isEmpty()) {return null;}
			
		Long id = Long.valueOf(text);
		return departamentoService.findById(id);
	}

}

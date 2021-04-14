package com.treinamento.spring.hsc.web.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.treinamento.spring.hsc.domain.Cargo;
import com.treinamento.spring.hsc.service.CargoService;

@Component
public class StringToCargoConverter implements Converter<String, Cargo> {
	
	@Autowired
	CargoService cargoService;
	
	@Override
	public Cargo convert(String text) {
		if(text.isEmpty()) {return null;}
			
		Long id = Long.valueOf(text);
		return cargoService.findById(id);
	}

}

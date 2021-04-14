package com.treinamento.spring.hsc.web.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class Long2LongTestConverter implements Converter<String, String> {

	@Override
	public String convert(String text) {
		return String.valueOf(text);
	}
}
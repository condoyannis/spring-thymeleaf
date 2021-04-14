package com.treinamento.spring.hsc.web.validator;

import java.time.LocalDate;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.treinamento.spring.hsc.domain.Funcionario;

public class FuncionarioValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Funcionario.class.equals(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		Funcionario funcionario = (Funcionario) object;
		LocalDate dataEntrada = funcionario.getDataEntrada();

		if (funcionario.getDataSaida() != null) {
			LocalDate dataSaida = funcionario.getDataSaida();

			if (dataEntrada.isBefore(dataSaida)) {
				errors.rejectValue("dataSaida",  "PosteriorDataEntrada.funcionario.dataSaida");
			}
		}
	}

}
package com.treinamento.spring.hsc.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

@Component
public class MyErrorView implements ErrorViewResolver{

	@Override
	public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status, Map<String, Object> map) {
		map.forEach((k,v) -> System.out.println(k+": "+v)) ;
		ModelAndView  modelAndView=new ModelAndView("error");
		modelAndView.addObject("status", status.value());
		switch (status.value()) {
		case 404:
			modelAndView.addObject("error","Pagina não encontrada");
			modelAndView.addObject("message", "url invalida: "+map.get("path"));
			break;
		case 500:
			modelAndView.addObject("error","Erro interno");
			modelAndView.addObject("message", "Erro inesperado ");
			break;

		default:
			modelAndView.addObject("error",map.get("error"));
			modelAndView.addObject("message", map.get("message"));
			break;
		}
		return modelAndView;
	}

}

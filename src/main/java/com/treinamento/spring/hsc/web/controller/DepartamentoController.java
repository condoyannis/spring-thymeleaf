package com.treinamento.spring.hsc.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.treinamento.spring.hsc.domain.Departamento;
import com.treinamento.spring.hsc.service.DepartamentoService;

@Controller
@RequestMapping("departamentos")
public class DepartamentoController {
	
	@Autowired
	private DepartamentoService service;
	
	@GetMapping("/cadastrar")
	private String cadastrar(Departamento departamento) {
		return "departamento/cadastro";
	}

	@GetMapping("/listar")
	private String listar(ModelMap model) {
		model.addAttribute("departamentos", service.findAll());
		return "departamento/lista";
	}
	
	@PostMapping("/salvar")
	private String salvar(@Valid Departamento departamento, BindingResult result, RedirectAttributes att) {
		if(result.hasErrors()) {
			return "departamento/cadastro";
		}
		service.save(departamento);
		att.addFlashAttribute("success", "Departamento inserido com sucesso");
		return "redirect:/departamentos/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	private String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("departamento", service.findById(id));
		return "departamento/cadastro";
	}
	
	@PostMapping("/editar")
	private String editar(@Valid Departamento departamento, BindingResult result,  RedirectAttributes att) {
		if(result.hasErrors()) {
			return "departamento/cadastro";
		}
		service.update(departamento);
		att.addFlashAttribute("success", "Departamento editado com sucesso");
		return "redirect:/departamentos/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	private String excluir(@PathVariable("id") Long id, ModelMap model) {
		if(service.departamentoHasCargos(id)) {
			model.addAttribute("fail", "Departamento não removido - Possui cargo");
		}else {
			service.delete(id);
			model.addAttribute("success", "Departamento excluido com sucesso.");
		}
		return listar(model);
	}
}

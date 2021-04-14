package com.treinamento.spring.hsc.web.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.treinamento.spring.hsc.domain.Cargo;
import com.treinamento.spring.hsc.domain.Funcionario;
import com.treinamento.spring.hsc.domain.UF;
import com.treinamento.spring.hsc.service.CargoService;
import com.treinamento.spring.hsc.service.FuncionarioService;
import com.treinamento.spring.hsc.web.validator.FuncionarioValidator;

@Controller
@RequestMapping("funcionarios")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService funcionarioService;

	@Autowired
	private CargoService cargoService;
	
	@InitBinder
	public void initBiding(WebDataBinder binder) {
		binder.addValidators(new FuncionarioValidator());
		
	}
	@GetMapping("/cadastrar")
	private String cadastrar(Funcionario funcionario) {
		return "funcionario/cadastro";

	}

	@GetMapping("/listar")
	private String listar(ModelMap model) {
		model.addAttribute("funcionarios", funcionarioService.findAll());
		return "funcionario/lista";
	}
	
	@PostMapping("/salvar")
	private String salvar(@Valid Funcionario funcionario,  BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "funcionario/cadastro";
		}
		funcionarioService.save(funcionario);
		attr.addFlashAttribute("success", "Funcionario Inserido com sucesso.");
		return "redirect:/funcionarios/cadastrar";
	}
	
	@ModelAttribute("cargos")
	public List<Cargo> getCargos(){
		return cargoService.findAll();
	}
	
	@ModelAttribute("ufs")
	public UF[] getUFs(){
		return UF.values();
	}
	

	@GetMapping("/editar/{id}")
	private String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("funcionario", funcionarioService.findById(id));
		return "funcionario/cadastro";
	}
	
	@PostMapping("/editar")
	private String editar(Funcionario funcionario, RedirectAttributes att) {
		funcionarioService.update(funcionario);
		att.addFlashAttribute("success", "Funcionario editado com sucesso");
		return "redirect:/funcionarios/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	private String excluir(@PathVariable("id") Long id, ModelMap model) {
		funcionarioService.delete(id);
		model.addAttribute("success", "Funcionario excluido com sucesso.");
		return listar(model);
	}
	
	@GetMapping("/buscar/nome")
	private String listar(@RequestParam("nome") String name, ModelMap model) {
		model.addAttribute("funcionarios", funcionarioService.findByName(name));
		return "funcionario/lista";
	}
	
	@GetMapping("/buscar/cargo")
	private String getByCargo(@RequestParam("id") Long id, ModelMap model) {
		model.addAttribute("funcionarios", funcionarioService.findByCargo(id));
		return "funcionario/lista";
	}
	
	@GetMapping("/buscar/data")
	private String getByDatas(@RequestParam(name = "entrada",  required=false )  @DateTimeFormat(iso = ISO.DATE) LocalDate entrada, 
							@RequestParam(name = "saida", required=false) @DateTimeFormat(iso = ISO.DATE)  LocalDate saida, ModelMap model) {
		model.addAttribute("funcionarios", funcionarioService.findByData(entrada, saida));
		return "funcionario/lista";
	}
}
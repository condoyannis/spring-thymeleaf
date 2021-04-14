package com.treinamento.spring.hsc.web.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.treinamento.spring.hsc.domain.Cargo;
import com.treinamento.spring.hsc.domain.Departamento;
import com.treinamento.spring.hsc.service.CargoService;
import com.treinamento.spring.hsc.service.DepartamentoService;
import com.treinamento.spring.hsc.util.PaginacaoUtil;

@Controller
@RequestMapping("cargos")
public class CargoController {
	
	@Autowired
	private CargoService cargoService;
	
	@Autowired
	private DepartamentoService departamentoService;
	
	@GetMapping("/cadastrar")
	private String cadastrar(Cargo cargo) {
		return "cargo/cadastro";
	}

	@GetMapping("/listar")
	private String listar(ModelMap model, @RequestParam("page") Optional<Integer> page,
			@RequestParam("dir") Optional<String> dir) {
		
		int paginaAtual = page.orElse(1);
		String ordem=dir.orElse("asc");
		PaginacaoUtil<Cargo> pageCargo = cargoService.buscaPaginada(paginaAtual,ordem);
		
//		model.addAttribute("cargos", cargoService.findAll());
		model.addAttribute("cargos",pageCargo);

		return "cargo/lista";
	}
	
	@PostMapping("/salvar")
	private String salvar(@Valid Cargo cargo, BindingResult result, RedirectAttributes attr) {
		if(result.hasErrors()) {
			return "cargo/cadastro";
		}
		cargoService.save(cargo);
		attr.addFlashAttribute("success", "Cargo Inserido com sucesso.");
		return "redirect:/cargos/cadastrar";
	}
	
	@ModelAttribute("departamentos")
	public List<Departamento> listaDeDepartamentos(){
		return departamentoService.findAll();
	}
	
	@GetMapping("/editar/{id}")
	private String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("cargo", cargoService.findById(id));
		return "cargo/cadastro";
	}
	@PostMapping("/editar")
	private String editar(@Valid Cargo cargo, BindingResult result, RedirectAttributes att) {
		if(result.hasErrors()) {
			return "cargo/cadastro";
		}
		cargoService.update(cargo);
		att.addFlashAttribute("success", "Cargo editado com sucesso");
		return "redirect:/cargos/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	private String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		if(cargoService.cargoHasCargos(id)) {
			attr.addFlashAttribute("fail", "Cargo não removido - Possui funcionarios");
		}else {
			cargoService.delete(id);
			attr.addFlashAttribute("success", "Cargo excluido com sucesso.");
		}
		return "redirect:/cargos/listar";
	}
}
